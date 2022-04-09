package ru.projects.format.service.statistics;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.statistics.BodyWeight;
import ru.projects.format.model.statistics.BodyWeightList;
import ru.projects.format.model.user.User;
import ru.projects.format.repository.statistics.BodyWeightRepository;

@RequiredArgsConstructor
@Service
public class BodyWeightService {
    private final BodyWeightRepository bodyWeightRepository;

    public BodyWeightList getBodyWeightListByUser(final User user) {
        return new BodyWeightList(bodyWeightRepository.findAllByKeyUser(user));
    }

    public boolean saveBodyWeight(final BodyWeight bodyWeight) {
        bodyWeightRepository.save(bodyWeight);
        return bodyWeightRepository.existsById(bodyWeight.getKey());
    }
}