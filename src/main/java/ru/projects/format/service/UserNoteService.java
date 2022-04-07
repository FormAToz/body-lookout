package ru.projects.format.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.note.Note;
import ru.projects.format.model.note.NoteCategoryList;
import ru.projects.format.model.note.NoteList;
import ru.projects.format.repository.note.NoteCategoryRepository;
import ru.projects.format.repository.note.NoteRepository;

@RequiredArgsConstructor
@Service
public class UserNoteService {
    private final NoteRepository noteRepository;
    private final NoteCategoryRepository noteCategoryRepository;
    private final UserService userService;

    public NoteList getNoteListByUserId(final long userId) {
        return new NoteList(noteRepository.findAllByUserId(userId));
    }

    public NoteCategoryList getNoteCategoryList() {
        return new NoteCategoryList(noteCategoryRepository.findAll());
    }

    public boolean addNote(final Note note) {
        noteRepository.save(note);
        return noteRepository.existsById(note.getId());
    }
}
