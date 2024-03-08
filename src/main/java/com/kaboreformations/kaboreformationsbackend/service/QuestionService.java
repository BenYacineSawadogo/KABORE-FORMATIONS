package com.kaboreformations.kaboreformationsbackend.service;

import com.kaboreformations.kaboreformationsbackend.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaboreformations.kaboreformationsbackend.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question getQuestionByID(Long id){
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> questionList(){
        return questionRepository.findAll();
    }

    public Question updateQuestion(Question question){
        Question newQuestion;
        Optional<Question> optionalQuestion = questionRepository.findById(question.getId());
        if(optionalQuestion.isPresent()){
            newQuestion = optionalQuestion.get();
            newQuestion.setQuestionText(question.getQuestionText());
            questionRepository.save(question);
        }
        else return new Question();
        return newQuestion;
    }

    public String deleteQuestion(Long id){
        questionRepository.deleteById(id);
        return "Deleted succesfully";
    }

}
