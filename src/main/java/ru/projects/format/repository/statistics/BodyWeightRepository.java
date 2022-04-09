package ru.projects.format.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.projects.format.model.statistics.BodyWeight;
import ru.projects.format.model.user.User;

import java.util.List;

@Repository
public interface BodyWeightRepository extends JpaRepository<BodyWeight, BodyWeight.BodyWeightKey> {
    List<BodyWeight> findAllByKeyUser(final User user);
}