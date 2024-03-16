package com.kaboreformations.kaboreformationsbackend.controller;

import com.kaboreformations.kaboreformationsbackend.service.QuestionService;
import com.kaboreformations.kaboreformationsbackend.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question){return  questionService.createQuestion(question);}

    @GetMapping("/question/{id}")
    public  Question getQuestionById(@PathVariable Long id){return  questionService.getQuestionByID(id);}
    @GetMapping("/question/questionList")
    public List <Question> questionList(){return  questionService.questionList();}
    @PutMapping("/question/questionUpdate")
    public Question updateQuestion(@RequestBody Question question){return  questionService.updateQuestion(question);}
    @DeleteMapping("/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable Long id){return  questionService.deleteQuestion(id);}

}
