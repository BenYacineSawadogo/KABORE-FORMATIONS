package com.kaboreformations.kaboreformationsbackend.controller;

import com.kaboreformations.kaboreformationsbackend.model.Answer;
import com.kaboreformations.kaboreformationsbackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/createAnswer")
    public Answer createAnswer(@RequestBody Answer answer){
        return answerService.createAnswer(answer);
    }

    @GetMapping("/answer/{id}")
    public Answer getAnswerById(@PathVariable Long id){
        return answerService.getAnswerById(id);
    }
    @GetMapping("/answer/answerUpdate")
    public List <Answer> answerList(){
        return answerService.answerList();
    }

    @PutMapping("/deleteAnswer")
    public  Answer uppdateAnswer(@RequestBody Answer answer){
        return answerService.updateAnswer(answer);
    }

    @DeleteMapping
    public String deleteAsnwer(@PathVariable Long id){
        return answerService.deleteAnswer(id);

    }
}
