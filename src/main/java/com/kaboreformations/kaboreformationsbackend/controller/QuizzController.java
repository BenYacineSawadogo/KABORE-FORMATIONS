package com.kaboreformations.kaboreformationsbackend.controller;

import com.kaboreformations.kaboreformationsbackend.model.Quizz;
import com.kaboreformations.kaboreformationsbackend.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "http://localhost:5173")
public class QuizzController {
    @Autowired
    private QuizzService quizzService;

    @PostMapping("/createQuizz")
    public Quizz createQuizz(@RequestBody Quizz quizz){

        return  quizzService.createQuizz(quizz);}
    @GetMapping("/{id}")
    public Quizz getQuizzById(@PathVariable Long id){return  quizzService.getQuizzById(id);}
    @GetMapping("score/{id}")
    public int getQuizzById(@PathVariable int id){return  quizzService.grade(id);}
    @GetMapping("/quizzList")
    public List <Quizz> quizzList(){return  quizzService.quizzList();}
    @PutMapping("/editQuizz")
    public Quizz quizzUpadte(@RequestBody Quizz quizz){return quizzService.updateQuizz(quizz);}
    @DeleteMapping("/deleteQuizz/{id}")
    public String deleteQuizz(@PathVariable Long id){return  quizzService.deleteQuizz(id);}
}
