package com.startup.argo.survey.service;

import com.startup.argo.pack.model.Pack;
import com.startup.argo.survey.dto.SurveyCreateRequestDto;
import com.startup.argo.survey.dto.SurveyResponseDto;
import com.startup.argo.survey.model.Survey;
import com.startup.argo.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;
    public List<SurveyResponseDto> getAllSurveys() {
        return surveyRepository.findAll().stream().map(SurveyResponseDto::from).toList();
    }


    public SurveyResponseDto getSurveyById(UUID id) {
        Survey survey = getSurveyOrThrow(id);

        return SurveyResponseDto.from(survey);
    }

    private Survey getSurveyOrThrow(UUID id) {
        Optional<Survey> newsOrNull = surveyRepository.findById(id);
        return newsOrNull.orElseThrow(
                () -> new RuntimeException("Survey not found"));
    }

    public SurveyResponseDto createSurvey(SurveyCreateRequestDto surveyCreateRequestDto) {
        Survey survey = new Survey();

        survey.setTitle(surveyCreateRequestDto.title());
        survey.setDescription(surveyCreateRequestDto.description());
        survey.setPrize(surveyCreateRequestDto.prize());
        survey.setType(surveyCreateRequestDto.type());
        survey.setQuestions(surveyCreateRequestDto.questions());
        survey.setPostedBy(surveyCreateRequestDto.postedBy());
        survey.setPublishedAt(surveyCreateRequestDto.publishedAt());
        survey.setCategories(surveyCreateRequestDto.categories());

        survey = surveyRepository.save(survey);

        return SurveyResponseDto.from(survey);
    }

    public SurveyResponseDto updateSurvey(UUID id, SurveyCreateRequestDto surveyCreateRequestDto) {
        Survey updatedSurvey = getSurveyOrThrow(id);

        updatedSurvey.setTitle(surveyCreateRequestDto.title());
        updatedSurvey.setDescription(surveyCreateRequestDto.description());
        updatedSurvey.setPrize(surveyCreateRequestDto.prize());
        updatedSurvey.setType(surveyCreateRequestDto.type());
        updatedSurvey.setQuestions(surveyCreateRequestDto.questions());
        updatedSurvey.setPostedBy(surveyCreateRequestDto.postedBy());
        updatedSurvey.setPublishedAt(surveyCreateRequestDto.publishedAt());
        updatedSurvey.setCategories(surveyCreateRequestDto.categories());

        Survey savedSurvey = surveyRepository.save(updatedSurvey);

        return SurveyResponseDto.from(savedSurvey);
    }

    public void deleteSurvey(UUID id) {
        surveyRepository.deleteById(id);
    }
}
