package com.kaboreformations.kaboreformationsbackend.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "question")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "questionId")
public class Question {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionId")
    private Long questionId;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    @Column(name = "questionText")
    private String questionText;
    @Column(name = "type")
    private String type;

    public Long getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(Long quizzId) {
        this.quizzId = quizzId;
    }

    @Column(name = "quizzId")
    private Long quizzId;
    @ManyToOne
    @JoinColumn(name = "quizzId",referencedColumnName = "quizzId",updatable = false,insertable = false)
    private Quizz quizz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

}
