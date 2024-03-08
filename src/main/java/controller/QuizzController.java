package controller;

import model.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.QuizzSercice;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizzController {
    @Autowired
    private QuizzSercice quizzSercice;

    @PostMapping("/createQuizz")
    public Quizz createquizz(@RequestBody Quizz quizz){return  quizzSercice.createQuizz(quizz);}
    @GetMapping("/{id}")
    public Quizz getQuizzById(@PathVariable Long id){return  quizzSercice.getQuizzById(id);}
    @GetMapping("/quizzList")
    public List <Quizz> quizzList(){return  quizzSercice.quizzList();}
    @PutMapping("/editQuizz")
    public Quizz quizzUpadte(@RequestBody Quizz quizz){return quizzSercice.updateQuizz(quizz);}
    @DeleteMapping("/deleteQuizz/{id}")
    public String deleteQuizz(@PathVariable Long id){return  quizzSercice.deleteQuizz(id);}
}
