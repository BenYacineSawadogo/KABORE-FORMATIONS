package com.kaboreformations.kaboreformationsbackend.service;

import com.kaboreformations.kaboreformationsbackend.model.Question;
import com.kaboreformations.kaboreformationsbackend.model.Quizz;
import com.kaboreformations.kaboreformationsbackend.repository.AnswerRepository;
import com.kaboreformations.kaboreformationsbackend.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaboreformations.kaboreformationsbackend.repository.QuizzRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {
    @Autowired
    private QuizzRepository quizzRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public Quizz createQuizz(Quizz quizz){
        Quizz q = quizzRepository.save(quizz);
        quizz.getQuestions().forEach(question -> {
            question.setQuizzId(q.getQuizzId());
            Question qs = questionRepository.save(question);
            question.getAnswers().forEach(answer -> {
                answer.setQuestionId(qs.getQuestionId());
                answerRepository.save(answer);
            });
        });
        return quizzRepository.save(quizz);
    }
    public Quizz getQuizzById(Long id){
        return quizzRepository.findById(id).orElse(null);
    }
    public List<Quizz> quizzList(){
      return   quizzRepository.findAll();
    }

    public Quizz updateQuizz(Quizz quizz){
        Quizz newQuizz;
        Optional<Quizz> optionalQuizz = quizzRepository.findById(quizz.getQuizzId());
        if(optionalQuizz.isPresent()){
            newQuizz = optionalQuizz.get();
            newQuizz.setTitre(quizz.getTitre());
            quizzRepository.save(quizz);
        }
        else  throw new EntityNotFoundException("Quizz not found with id: " + quizz.getQuizzId());;
        return newQuizz;
    }

    public  String deleteQuizz(Long id){
        quizzRepository.deleteById(id);
        return "Deleted Successfully";
    }
    int score = 0;
    public int grade(long quizzId){
       score=0;
        Optional<Quizz> q = quizzRepository.findById(quizzId);
        q.get().getQuestions().forEach(question -> {
            question.getAnswers().forEach(answer -> {
               score +=answerRepository.countAnswersByAnswerIdAndCorrect(question.getQuestionId(),true);
            });
        });

        return score;
    }


}
