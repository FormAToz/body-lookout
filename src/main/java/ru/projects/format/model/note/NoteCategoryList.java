package ru.projects.format.model.note;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.commons.collections4.ListUtils;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;

import java.util.List;

@Setter
@AllArgsConstructor
public class NoteCategoryList implements ModelAttribute {
    private List<NoteCategory> noteCategoryList;

    public List<NoteCategory> getNoteCategoryList() {
        return ListUtils.emptyIfNull(noteCategoryList);
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.NOTE_CATEGORY_LIST;
    }

    @Override
    public String toString() {
        return "NoteCategoryList{" +
                "noteCategoryList=" + noteCategoryList +
                '}';
    }
}