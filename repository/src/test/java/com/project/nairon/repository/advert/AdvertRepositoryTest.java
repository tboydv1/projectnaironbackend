package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.Advert;
import com.project.nairon.models.advert.AdvertBudget;
import com.project.nairon.models.advertiser.Advertiser;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.naironuser.NaironUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oluwatobi
 *
 */

@SpringBootTest(classes = RepositoryConfig.class)
@Sql(scripts = {"classpath:/db/insert-users.sql","classpath:/db/insert-adverts.sql" })
class AdvertRepositoryTest {

    @Autowired
    AdvertRepository advertRepository;

    @Autowired
    NaironUserRepository naironUserRepository;

    @Autowired
    QuestionnaireRepository questionnaireRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AdvertBudgetRepository advertBudgetRepository;

    Logger logger = Logger.getLogger(getClass().getName());


    @BeforeEach
    void setUp() {
    }

    @Test
    public void createAdvertTest(){

        //Fetch a user from the database
        NaironUser existingUser = naironUserRepository.findById(45).get();

        assertThat(existingUser).isNotNull();

        //create an advert
        Advert advert1 = new Advert();
        advert1.setAgeRange("18-60");
        advert1.setUserId(existingUser);
        advert1.setTitle("Jumbotrons");
        advert1.setPlacementType("Automatic");
        advert1.setTargetLocation("Yaba#Songo");
        advert1.setGender("Male");

        //create a budget
        AdvertBudget budget1 = new AdvertBudget();
        budget1.setBudgetAmount(40000.00);
        budget1.setBudgetBalance(0.0);
        budget1.setBudgetPerDay(500.00);


        //set the advert budget
        advert1.setAdvertBudget(budget1);

        advertRepository.save(advert1);

        logger.info(""+advert1);
        logger.info(""+budget1);

        assertThat(advertRepository.findById(advert1.getAdvertId()).get()).isNotNull();
        assertThat(advertBudgetRepository.findById(budget1.getBudgetId()).get()).isNotNull();

    }
}