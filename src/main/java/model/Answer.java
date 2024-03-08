package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answers")
public class Answer {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    private long id;
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;
}
