package com.kaboreformations.kaboreformationsbackend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "question")
public class Question {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "questionId")
    private Long id;

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
    @ManyToOne
    @JoinColumn(name = "quizzId",nullable = false)
    private Quizz quizz;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

}
