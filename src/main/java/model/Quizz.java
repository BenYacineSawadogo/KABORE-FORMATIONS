package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "quizz")
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "quizzId")
    private Long id;
    @Column(name = "titre")
    private String titre;
    @OneToMany(mappedBy = "quizz", cascade = CascadeType.ALL)
    private List <Question> questions = new ArrayList<>();

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
