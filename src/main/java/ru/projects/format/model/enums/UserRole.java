package ru.projects.format.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("Администратор"),
    USER("Пользователь");

    private final String description;
}