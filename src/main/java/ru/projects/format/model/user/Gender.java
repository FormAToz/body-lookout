package ru.projects.format.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Entity
@Table(name = "genders")
public class Gender {
    @Id
    private String value;
    private String description;
}