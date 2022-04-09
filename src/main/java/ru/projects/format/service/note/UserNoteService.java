package ru.projects.format.service.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.note.Note;
import ru.projects.format.model.note.NoteCategoryList;
import ru.projects.format.model.note.NoteList;
import ru.projects.format.model.user.User;
import ru.projects.format.repository.note.NoteCategoryRepository;
import ru.projects.format.repository.note.NoteRepository;
import ru.projects.format.service.UserService;

@RequiredArgsConstructor
@Service
public class UserNoteService {
    private final NoteRepository noteRepository;
    private final NoteCategoryRepository noteCategoryRepository;
    private final UserService userService;

    public NoteList getNoteListByUser(final User user) {
        return new NoteList(noteRepository.findAllByUser(user));
    }

    public NoteCategoryList getNoteCategoryList() {
        return new NoteCategoryList(noteCategoryRepository.findAll());
    }

    public boolean addNote(final Note note) {
        noteRepository.save(note);
        return noteRepository.existsById(note.getId());
    }
}