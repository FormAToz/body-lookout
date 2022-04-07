package ru.projects.format.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.projects.format.model.user.GenderList;
import ru.projects.format.repository.GenderRepository;

@RequiredArgsConstructor
@Service
public class GenderService {
    private final GenderRepository genderRepository;

    public GenderList getGenderList() {
        return new GenderList(genderRepository.findAll());
    }
}