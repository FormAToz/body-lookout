package ru.projects.format.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.projects.format.model.note.Note;
import ru.projects.format.model.user.User;
import ru.projects.format.service.note.UserNoteService;
import ru.projects.format.service.UserService;

import static ru.projects.format.constant.UrlNames.NOTES_ALL;
import static ru.projects.format.controller.ControllerHelper.addAttribute;
import static ru.projects.format.controller.ControllerHelper.changeView;
import static ru.projects.format.controller.ControllerHelper.redirectOnView;

@RequiredArgsConstructor
@Controller
public class UserNoteController {
    public static final Logger log = LoggerFactory.getLogger(UserNoteController.class);

    private final UserService userService;
    private final UserNoteService userNoteService;

    @GetMapping(NOTES_ALL)
    public String openUserNotesPage(final Model model) {
        log.info("openUserNotesPage(): model={}", model);

        final User user = userService.getById(1L); // TODO брать из Auth, когда прикрутится Security
        addAttribute(model, user);
        addAttribute(model, userNoteService.getNoteListByUser(user));
        addAttribute(model, userNoteService.getNoteCategoryList());
        addAttribute(model, new Note());
        return changeView(NOTES_ALL);
    }

    @PostMapping(NOTES_ALL)
    public String addNote(final Note note) {
        log.info("addNote(): note={}", note);

        userNoteService.addNote(note);
        return redirectOnView(NOTES_ALL);
    }
}