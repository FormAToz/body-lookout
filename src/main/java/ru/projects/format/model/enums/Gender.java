package ru.projects.format.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский");

    private final String description;

    @Override
    public String toString() {
        return "Gender{" +
                "name='" + name() + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}