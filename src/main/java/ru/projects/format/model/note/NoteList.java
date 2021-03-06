package ru.projects.format.model.note;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.ListUtils;
import ru.projects.format.constant.AttributeName;
import ru.projects.format.model.ModelAttribute;

import java.util.List;

@ToString
@Setter
@AllArgsConstructor
public class NoteList implements ModelAttribute {
    private List<Note> noteList;

    public List<Note> getNoteList() {
        return ListUtils.emptyIfNull(noteList);
    }

    @Override
    public @NonNull String getAttributeName() {
        return AttributeName.NOTE_LIST;
    }
}