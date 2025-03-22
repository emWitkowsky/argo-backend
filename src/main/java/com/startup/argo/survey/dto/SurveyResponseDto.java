package com.startup.argo.survey.dto;

import com.startup.argo.survey.model.Survey;
import jakarta.annotation.Nonnull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record SurveyResponseDto(
        UUID id,
        String title,
        String description,
        String prize,
        SurveyType type,
        List<String> questions,
        String postedBy,
        LocalDate publishedAt,
        List<String> categories
) {
    public static SurveyResponseDto from(@Nonnull Survey survey) {
        return new SurveyResponseDto(
                survey.getId(),
                survey.getTitle(),
                survey.getDescription(),
                survey.getPrize(),
                survey.getType(),
                survey.getQuestions(),
                survey.getPostedBy(),
                survey.getPublishedAt(),
                survey.getCategories()
        );
    }

}
