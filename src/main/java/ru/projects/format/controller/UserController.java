package ru.projects.format.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.projects.format.model.user.User;
import ru.projects.format.service.GenderService;
import ru.projects.format.service.UserService;

import static ru.projects.format.constant.UrlNames.USERS_ADD;
import static ru.projects.format.controller.ControllerHelper.addAttribute;
import static ru.projects.format.controller.ControllerHelper.changeView;
import static ru.projects.format.controller.ControllerHelper.redirectOnView;

@RequiredArgsConstructor
@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final GenderService genderService;

    @GetMapping(USERS_ADD)
    public String getAllUsers(final Model model) {
        log.info("getAllUsers(): model={}", model);

        addAttribute(model, genderService.getGenderList());
        addAttribute(model, userService.getUserList());
        addAttribute(model, new User());
        return changeView(USERS_ADD);
    }

    @PostMapping(USERS_ADD)
    public String addNewUser(final User user) {
        log.info("addNewUser(): user={}", user);

        userService.saveUser(user);
        return redirectOnView(USERS_ADD);
    }
}