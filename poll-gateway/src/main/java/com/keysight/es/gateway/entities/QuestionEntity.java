package com.keysight.es.gateway.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Poll;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;
    @ElementCollection
    private List<String> availableAnswers=new LinkedList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonBackReference("poll-question")
    private List<PollEntity> poll=new LinkedList<>();
    public void addAvailableAnswer(String answer)
    {
        this.availableAnswers.add(answer);
    }
}
