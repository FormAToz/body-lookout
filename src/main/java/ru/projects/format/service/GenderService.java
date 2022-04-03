package ru.projects.format.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.Gender;
import ru.projects.format.repository.GenderRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenderService {
    private final GenderRepository genderRepository;

    public List<Gender> geAllGenderList() {
        return genderRepository.findAll();
    }
}
