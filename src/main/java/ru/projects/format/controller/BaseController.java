package ru.projects.format.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.projects.format.service.UserService;

@RequiredArgsConstructor
@Controller
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    private final UserService userService;

    @GetMapping
    public String getIndexPage(final Model model) {
        log.info("getIndexPage(): model={}", model);
        model.addAttribute("user_list", userService.getAllUserList());
        return "index";
    }
}
