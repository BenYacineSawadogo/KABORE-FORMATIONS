package com.kaboreformations.kaboreformationsbackend.repository;

import com.kaboreformations.kaboreformationsbackend.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizzRepository extends JpaRepository<Quizz,Long> {
}
