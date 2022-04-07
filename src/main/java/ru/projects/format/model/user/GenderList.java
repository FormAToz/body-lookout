package ru.projects.format.model.user;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.collections4.ListUtils;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;

import java.util.List;

@Setter
@AllArgsConstructor
public class GenderList implements ModelAttribute {
    private List<Gender> genderList;

    public List<Gender> getGenderList() {
        return ListUtils.emptyIfNull(genderList);
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.GENDER_LIST;
    }

    @Override
    public String toString() {
        return "GenderList{" +
                "genderList=" + genderList +
                '}';
    }
}