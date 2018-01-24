package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<QuestionEntity> getQuestions() {
        return this.questionRepository.findAll();
    }
}
