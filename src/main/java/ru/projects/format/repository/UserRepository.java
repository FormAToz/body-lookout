package ru.projects.format.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.projects.format.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
