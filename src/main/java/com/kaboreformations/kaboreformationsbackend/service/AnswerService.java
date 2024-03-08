package com.kaboreformations.kaboreformationsbackend.service;

import com.kaboreformations.kaboreformationsbackend.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaboreformations.kaboreformationsbackend.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public Answer getAnswerById(Long id){
        return answerRepository.findById(id).orElse(null);
    }

    public List <Answer> answerList(){
        return  answerRepository.findAll();
    }
    public Answer updateAnswer(Answer answer){
        Answer newAnswer;
        Optional<Answer> optionalAnswer = answerRepository.findById(answer.getId());
        if(optionalAnswer.isPresent()){
            newAnswer = optionalAnswer.get();
            newAnswer.setText(answer.getText());
            newAnswer.setCorrect(answer.isCorrect());
            answerRepository.save(newAnswer);
        }
        else return new Answer();
        return newAnswer;
    }

    public String deleteAnswer(Long id){
        answerRepository.deleteById(id);
        return "deleted successfully";
    }
}
