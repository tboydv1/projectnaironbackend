package com.project.nairon.repository.questionnaire;

import com.project.nairon.models.questionnaire.Device;
import com.project.nairon.models.questionnaire.Question;
import com.project.nairon.models.questionnaire.Questionnaire;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.advert.DeviceRepository;
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
    DeviceRepository deviceRepository;

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


        Device deviceList = new Device();
        deviceList.setBrandName("SAMSUNG");
        deviceList.setType("MOBILE");

        List<String> version = new ArrayList<>();

        version.add("S10");
        version.add("L14");
        version.add("Note4");
        version.add("A3");
        version.add("M24");
        version.add("S7");
        version.add("S3");

        deviceList.setVersion(version);
        deviceRepository.save(deviceList);

    }


}