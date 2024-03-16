package com.kaboreformations.kaboreformationsbackend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "answerId")
public class Answer {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answerId")
    private long answerId;
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private boolean correct;
    @Column(name = "questionId")
    private Long questionId;
    @ManyToOne
    @JoinColumn(name = "questionId",referencedColumnName = "questionId",insertable = false,updatable = false)
    private Question question;
}
