package ru.projects.format.service.statistics;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;
import ru.projects.format.model.statistics.BodyPart;
import ru.projects.format.model.statistics.BodySize;
import ru.projects.format.model.user.User;
import ru.projects.format.repository.statistics.BodyPartRepository;
import ru.projects.format.repository.statistics.BodySizeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BodySizeService {
    private final BodyPartRepository bodyPartRepository;
    private final BodySizeRepository bodySizeRepository;

    public ModelAttribute getBodyPartList() {
        return new ModelAttribute() {
            public final List<BodyPart> bodyPartList = bodyPartRepository.findAll();

            @Override
            public @NonNull String getAttributeName() {
                return AttributeName.BODY_PART_LIST;
            }

            @Override
            public String toString() {
                return "{bodyPartList=" + bodyPartList + '}';
            }
        };
    }

    public ModelAttribute getBodySizeListByUser(final User user) {
        return new ModelAttribute() {
            public final List<BodySize> bodySizeList = bodySizeRepository.findByKeyUser(user);

            @Override
            public @NonNull String getAttributeName() {
                return AttributeName.BODY_SIZE_LIST;
            }

            @Override
            public String toString() {
                return "{bodySizeList=" + bodySizeList + '}';
            }
        };
    }

    public boolean saveBodySize(final BodySize bodySize) {
        bodySizeRepository.save(bodySize);
        return bodySizeRepository.existsById(bodySize.getKey());
    }
}