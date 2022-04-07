package ru.projects.format.model;

import lombok.NonNull;

@FunctionalInterface
public interface ModelAttribute {
    @NonNull
    String getAttributeName();
}
