package com.project.nairon.repository.advert;

import com.project.nairon.models.questionnaire.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author oluwatobi
 */

@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
