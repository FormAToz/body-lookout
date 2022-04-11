package ru.projects.format.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.projects.format.model.statistics.BodyPart;

@Repository
public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {
}