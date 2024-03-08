package service;

import model.Answer;
import model.Question;
import model.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.QuizzRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzSercice {
    @Autowired
    private QuizzRepository quizzRepository;

    public Quizz createQuizz(Quizz quizz){
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
        Optional<Quizz> optionalQuizz = quizzRepository.findById(quizz.getId());
        if(optionalQuizz.isPresent()){
            newQuizz = optionalQuizz.get();
            newQuizz.setTitre(quizz.getTitre());
            quizzRepository.save(quizz);
        }
        else return new Quizz();
        return newQuizz;
    }

    public  String deleteQuizz(Long id){
        quizzRepository.deleteById(id);
        return "Deleted Successfully";
    }


}
