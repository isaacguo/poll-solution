package com.keysight.es.gateway.services;

import com.keysight.es.gateway.entities.AnswerItemEntity;
import com.keysight.es.gateway.entities.PollEntity;
import com.keysight.es.gateway.entities.QuestionEntity;
import com.keysight.es.gateway.repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Data
@AllArgsConstructor
public class PollServiceImpl implements PollService {

    private final QuestionRepository questionRepository;

    @Override
    public boolean submitPoll(PollEntity[] polls) {

        if (polls == null) throw new RuntimeException();
        if (polls.length == 0) throw new RuntimeException();


        Arrays.stream(polls).forEach(r -> {
            try {
                QuestionEntity qe = questionRepository.findOne(r.getQuestion().getId());
                if (qe == null) throw new RuntimeException();
                AnswerItemEntity aie = qe.getAvailableAnswers().stream().filter(a -> {
                    return a.getId() == r.getAnswer().getId();
                }).findFirst().orElse(null);
                aie.increaseByOne();
                questionRepository.save(qe);
            } catch (Exception e) {

            }
        });

        return true;
    }


}
