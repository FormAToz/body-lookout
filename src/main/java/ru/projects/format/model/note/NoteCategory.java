package ru.projects.format.model.note;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "note_categories")
public class NoteCategory {
    @Id
    private long id;
    private String description;

    @Override
    public String toString() {
        return "NoteCategory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
