package ru.projects.format.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.user.User;
import ru.projects.format.model.user.UserList;
import ru.projects.format.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public boolean saveUser(final User user) {
        userRepository.save(user);
        return userRepository.existsById(user.getId());
    }

    public UserList getUserList() {
        return new UserList(userRepository.findAll());
    }

    public User getById(final long id) {
        return userRepository.getById(id);
    }
}