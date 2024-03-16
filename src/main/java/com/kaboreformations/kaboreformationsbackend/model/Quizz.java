package com.kaboreformations.kaboreformationsbackend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "quizz")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "quizzId")
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quizzId")
    private Long quizzId;
    @Column(name = "titre")
    private String titre;
    @OneToMany(mappedBy = "quizz",cascade = CascadeType.ALL,orphanRemoval = true)
    private List <Question> questions = new ArrayList<>();

    public Long getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(Long quizzId) {
        this.quizzId = quizzId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

}


