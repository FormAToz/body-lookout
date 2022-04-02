package ru.projects.format.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.User;
import ru.projects.format.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public boolean saveUser(final User user) {
        userRepository.save(user);
        return userRepository.existsById(user.getId());
    }

    public List<User> getAllUserList() {
        return userRepository.findAll();
    }
}