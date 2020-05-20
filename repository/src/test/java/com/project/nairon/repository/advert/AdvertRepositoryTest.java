package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.Advert;
import com.project.nairon.models.advert.AdvertBudget;
import com.project.nairon.models.questionnaire.Device;
import com.project.nairon.models.questionnaire.Location;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.naironuser.NaironUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Oluwatobi
 *
 */

@SpringBootTest(classes = RepositoryConfig.class)
@Slf4j
@Sql(scripts = {"classpath:/db/insert-users.sql","classpath:/db/insert-adverts.sql","classpath:/db/insert-location.sql","classpath:/db/insert-business_category.sql","classpath:/db/insert-device.sql" })
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

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    DeviceRepository deviceRepository;



    Logger logger = Logger.getLogger(getClass().getName());


    @BeforeEach
    void setUp() {
    }

    @Test
    public void createAdvertTest(){

        //Fetch a user from the database
        NaironUser existingUser = naironUserRepository.findById(45).get();

        log.info("Fetched an existing user {}", existingUser);
        assertThat(existingUser).isNotNull();

        //create an advert
        Advert advert1 = new Advert();
        advert1.setAgeRange("18-60");
        advert1.setUserId(existingUser);
        advert1.setTitle("Jumbotrons");
        advert1.setPlacementType("Automatic");
        advert1.setGender("Male");



        //create a budget
        AdvertBudget budget1 = new AdvertBudget();
        budget1.setBudgetAmount(40000.00);
        budget1.setBudgetBalance(0.0);
        budget1.setBudgetPerDay(500.00);

        //set the advert budget
        advert1.setAdvertBudget(budget1);

        Location targetLocation = locationRepository.findById(21).get();
        log.info("Advert location {}", targetLocation);

        Device targetDevices = deviceRepository.findById(31).get();
        log.info("Advert devices {}", targetDevices);

        advert1.setLocationList(Collections.singletonList(targetLocation));

        advert1.setDeviceList(Collections.singletonList(targetDevices));

        log.info("Attempting save on advert object");
        advertRepository.save(advert1);

        logger.info("" + advert1);
        logger.info("" + budget1);

        Optional<Advert> savedAdvert = advertRepository.findById(advert1.getAdvertId());
        Optional<AdvertBudget> savedBudget = advertBudgetRepository.findById(budget1.getBudgetId());

        if(savedAdvert.isPresent()){

            assertThat(savedAdvert.get()).isNotNull();
            assertThat(savedBudget).get().isNotNull();

        }



    }
}