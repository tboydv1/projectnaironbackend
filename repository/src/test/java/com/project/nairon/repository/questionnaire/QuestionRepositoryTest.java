package com.project.nairon.repository.questionnaire;

import com.project.nairon.models.reference.RefMobileDevice;
import com.project.nairon.models.questionnaire.Question;
import com.project.nairon.models.questionnaire.Questionnaire;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.advert.RefAdCreationRepo;
import com.project.nairon.repository.advert.QuestionRepository;
import com.project.nairon.repository.advert.QuestionnaireRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    RefAdCreationRepo refAdCreationRepo;

    Logger logger = Logger.getLogger(getClass().getName());


    @BeforeEach
    void setUp() {
    }

    @Test
    void addNewQuestion(){

        Questionnaire questionnaire = questionnaireRepository.findById(200).get();

        logger.info("Existing questionnaire");



        List<Question> questionList = new ArrayList<>();
        Question question = new Question();
        question.setPageLevel(9);
        question.setQuestion("Is This a new Question? ");
        question.setDescription("This question has a description");
//        question.setQuestionnaireId(questionnaire);
        question.setAdvertProperty("Adverts");

        questionList.add(question);


        List<String> choices = new ArrayList<>();

        choices.add("Choice 1");
        choices.add("Choice 2");
        choices.add("Choice 3");
        choices.add("Choice 4");
        choices.add("Choice 5");

        question.setChoices(choices);


        questionRepository.save(question);
    }

    @Test
    void saveDevices_thenSaveList(){


        RefMobileDevice refMobileDeviceList = new RefMobileDevice();
        refMobileDeviceList.setBrandName("SAMSUNG");
//        refMobileDeviceList.setType("MOBILE");

        List<String> version = new ArrayList<>();

        version.add("S10");
        version.add("L14");
        version.add("Note4");
        version.add("A3");
        version.add("M24");
        version.add("S7");
        version.add("S3");

        refMobileDeviceList.setVersion(version);


    }


}