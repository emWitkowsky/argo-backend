package com.startup.argo.survey.controller;

import com.startup.argo.survey.dto.SurveyCreateRequestDto;
import com.startup.argo.survey.dto.SurveyResponseDto;
import com.startup.argo.survey.dto.SurveyType;
import com.startup.argo.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping
    public List<SurveyResponseDto> getAllSurveys() {
        return surveyService.getAllSurveys();
    }

    @GetMapping("/{id}")
    public SurveyResponseDto getSurveyById(@PathVariable UUID id) {
        return surveyService.getSurveyById(id);
    }

    @PostMapping
    public SurveyResponseDto createSurvey(
            @RequestParam String title,
    @RequestParam String description,
    @RequestParam String prize,
    @RequestParam SurveyType type,
    @RequestParam
    List<String> questions,
    @RequestParam String postedBy,
    @RequestParam
    LocalDate publishedAt,
    @RequestParam List<String> categories
    ) {
        SurveyCreateRequestDto surveyCreateRequestDto = new SurveyCreateRequestDto(title, description, prize, type, questions, postedBy, publishedAt, categories);

        return surveyService.createSurvey(surveyCreateRequestDto);
    }

    @PostMapping("/{id}")
    public SurveyResponseDto updateSurvey(
            @PathVariable UUID id,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String prize,
            @RequestParam SurveyType type,
            @RequestParam
            List<String> questions,
            @RequestParam String postedBy,
            @RequestParam
            LocalDate publishedAt,
            @RequestParam List<String> categories
    ) {
        SurveyCreateRequestDto surveyCreateRequestDto = new SurveyCreateRequestDto(title, description, prize, type, questions, postedBy, publishedAt, categories);

        return surveyService.updateSurvey(id, surveyCreateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable UUID id) {
        surveyService.deleteSurvey(id);
    }
}
