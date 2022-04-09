package ru.projects.format.model.statistics;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.ListUtils;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;

import java.util.List;

@ToString
@AllArgsConstructor
@Setter
public class BodyWeightList implements ModelAttribute {
    private List<BodyWeight> bodyWeightList;

    public List<BodyWeight> getBodyWeightList() {
        return ListUtils.emptyIfNull(bodyWeightList);
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.BODY_WEIGHT_LIST;
    }
}