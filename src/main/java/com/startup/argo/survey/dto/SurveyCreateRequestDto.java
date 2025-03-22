package com.startup.argo.survey.dto;

import java.time.LocalDate;
import java.util.List;

public record SurveyCreateRequestDto(
        String title,
        String description,
        String prize,
        SurveyType type,
        List<String> questions,
        String postedBy,
        LocalDate publishedAt,
        List<String> categories
) {
}
