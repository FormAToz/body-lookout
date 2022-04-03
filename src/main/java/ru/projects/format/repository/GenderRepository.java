package ru.projects.format.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.projects.format.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, String> {
}
