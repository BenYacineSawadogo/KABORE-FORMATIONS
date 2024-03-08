package com.kaboreformations.kaboreformationsbackend.repository;

import com.kaboreformations.kaboreformationsbackend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
