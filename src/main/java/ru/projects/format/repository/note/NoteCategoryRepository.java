package ru.projects.format.repository.note;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.projects.format.model.note.NoteCategory;

public interface NoteCategoryRepository extends JpaRepository<NoteCategory, Long> {
}
