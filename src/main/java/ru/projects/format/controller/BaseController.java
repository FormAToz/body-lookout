package ru.projects.format.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static ru.projects.format.constant.UrlNames.INDEX;
import static ru.projects.format.constant.UrlNames.ROOT;
import static ru.projects.format.controller.ControllerHelper.changeView;

@Controller
public class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @GetMapping({ROOT, INDEX})
    public String getIndexPage() {
        log.info("getIndexPage()");
        return changeView(INDEX);
    }
}