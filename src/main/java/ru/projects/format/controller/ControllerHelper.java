package ru.projects.format.controller;

import org.springframework.ui.Model;
import ru.projects.format.model.ModelAttribute;

public abstract class ControllerHelper {
    private static final String REDIRECT_PREFIX = "redirect:";

    protected static void addAttribute(final Model model, final ModelAttribute object) {
        model.addAttribute(object.getAttributeName(), object);
    }

    protected static String changeView(final String viewName) {
        return viewName;
    }

    protected static String redirectOnView(final String viewName) {
        return changeView(REDIRECT_PREFIX + viewName);
    }
}