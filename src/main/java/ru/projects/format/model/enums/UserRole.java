package ru.projects.format.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("Администратор"),
    USER("Пользователь");

    private final String description;

    @Override
    public String toString() {
        return "UserRole{" +
                "name='" + name() + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}