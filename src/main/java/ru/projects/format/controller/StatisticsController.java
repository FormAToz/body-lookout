package ru.projects.format.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.projects.format.model.statistics.BodySize;
import ru.projects.format.model.statistics.BodyWeight;
import ru.projects.format.model.user.User;
import ru.projects.format.service.UserService;
import ru.projects.format.service.statistics.BodySizeService;
import ru.projects.format.service.statistics.BodyWeightService;

import static ru.projects.format.constant.UrlNames.STATISTICS_BODY_SIZE;
import static ru.projects.format.constant.UrlNames.STATISTICS_WEIGHT;
import static ru.projects.format.controller.ControllerHelper.addAttribute;
import static ru.projects.format.controller.ControllerHelper.redirectOnView;

@RequiredArgsConstructor
@Controller
public class StatisticsController {
    private static final Logger log = LoggerFactory.getLogger(StatisticsController.class);

    private final UserService userService;
    private final BodyWeightService bodyWeightService;
    private final BodySizeService bodySizeService;

    @GetMapping(STATISTICS_WEIGHT)
    public String openStatisticsWeightPage(final Model model) {
        log.info("openStatisticsWeightPage(): model={}", model);

        final User user = userService.getById(1L); // TODO брать из Auth, когда прикрутится Security
        addAttribute(model, user);
        addAttribute(model, bodyWeightService.getBodyWeightListByUser(user));
        addAttribute(model, new BodyWeight());
        return STATISTICS_WEIGHT;
    }

    @PostMapping(STATISTICS_WEIGHT)
    public String addNewBodyWeight(final BodyWeight bodyWeight) {
        log.info("addNewBodyWeight(): bodyWeight={}", bodyWeight);

        bodyWeightService.saveBodyWeight(bodyWeight);
        return redirectOnView(STATISTICS_WEIGHT);
    }

    @GetMapping(STATISTICS_BODY_SIZE)
    public String openStatisticsBodySizesPage(final Model model) {
        log.info("openStatisticsBodySizesPage(): model={}", model);

        final User user = userService.getById(1L); // TODO брать из Auth, когда прикрутится Security
        addAttribute(model, user);
        addAttribute(model, bodySizeService.getBodyPartList());
        addAttribute(model, new BodySize());
        addAttribute(model, bodySizeService.getBodySizeListByUser(user));
        return STATISTICS_BODY_SIZE;
    }

    @PostMapping(STATISTICS_BODY_SIZE)
    public String addNewBodySize(final BodySize bodySize) {
        log.info("addNewBodySize(): bodySize={}", bodySize);

        bodySizeService.saveBodySize(bodySize);
        return redirectOnView(STATISTICS_BODY_SIZE);
    }
}