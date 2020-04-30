package com.project.nairon.repository.questionnaire;

import com.project.nairon.models.questionnaire.Question;
import com.project.nairon.models.questionnaire.Questionnaire;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.advert.QuestionRepository;
import com.project.nairon.repository.advert.QuestionnaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.logging.Logger;

/**
 * @Oluwatobi
 *
 */

@SpringBootTest(classes = RepositoryConfig.class)
@Sql(scripts = {"classpath:/db/insert-question.sql"})
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    Logger logger = Logger.getLogger(getClass().getName());


    @BeforeEach
    void setUp() {
    }

    @Test
    void addNewQuestion(){

        Questionnaire questionnaire = questionnaireRepository.findById(200).get();

        logger.info("Existing questionnaire");


        Question question = new Question();
        question.setPageLevel(9);
        question.setQuestion("Is This a new Question? ");
        question.setDescription("This question has a description");
        question.setQuestionnaireId(questionnaire);
        question.setAdvertProperty("Adverts");
        question.setChoice("#");

        questionRepository.save(question);
    }
}