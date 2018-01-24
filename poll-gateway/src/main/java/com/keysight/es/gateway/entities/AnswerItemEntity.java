package com.keysight.es.gateway.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnswerItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answer;
    private int selectedCount;

    @ManyToOne
    @JsonBackReference("question-answers")
    private QuestionEntity question;
    public void increaseByOne()
    {
        this.selectedCount++;
    }
}
