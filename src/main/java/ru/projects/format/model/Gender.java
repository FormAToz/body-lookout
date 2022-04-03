package ru.projects.format.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "genders")
public class Gender {
    @Id
    private String value;
    private String description;

    @Override
    public String toString() {
        return "Gender{" +
                "value='" + value + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
