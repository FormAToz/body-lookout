package ru.projects.format.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.projects.format.model.statistics.BodySize;
import ru.projects.format.model.user.User;

import java.util.List;

@Repository
public interface BodySizeRepository extends JpaRepository<BodySize, BodySize.BodySizeKey> {
    List<BodySize> findByKeyUser(final User user);
}