package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.AdHeadline;
import com.project.nairon.models.advert.Advert;
import com.project.nairon.models.advert.AdvertBudget;
import com.project.nairon.models.reference.RefAdsCreation;
import com.project.nairon.models.reference.RefMobileDevice;
import com.project.nairon.models.advert.Location;
import com.project.nairon.models.naironuser.NaironUser;
import com.project.nairon.repository.RepositoryConfig;
import com.project.nairon.repository.naironuser.NaironUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Oluwatobi
 *
 */

@SpringBootTest(classes = RepositoryConfig.class)
@Slf4j
@Sql(scripts = {"classpath:/db/insert-users.sql","classpath:/db/insert-adverts.sql","classpath:/db/insert-reference-data.sql"})
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
    RefAdCreationRepo refAdCreationRepo;



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
        advert1.setId(7575);
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
        budget1.setAdvert(advert1);

        //set the advert budget
        advert1.setAdvertBudget(budget1);

        //create advert healine
        AdHeadline adHeadline = new AdHeadline();
        adHeadline.setHeadline1("Sample headline 1");
        adHeadline.setHeadline2("Sample headline 2");
        adHeadline.setDescription1("This a sample description");
        adHeadline.setDescription1("This is another description");
        adHeadline.setDisplayUrl("https://myads.com/myadstitlehere");
        adHeadline.setImageUrl("https://cloud/imagestorage");

        advert1.setAdHeadlineList(Collections.singletonList(adHeadline));

        List<String> ispList = new ArrayList<>();
        ispList.add("MTN");
        ispList.add("AIRTEL");
        ispList.add("GLO");

        advert1.setIspTechnologies(ispList);

        Location location = new Location();
        location.setCountry("Nigeria");
        location.setState("Lagos");

        List<String> cities = new ArrayList<>();
        cities.add("Yaba");
        cities.add("Victoria Island");
        cities.add("Palmgroove");

        location.setCities(cities);

        Optional<RefAdsCreation> referenceData = refAdCreationRepo.findById(500);

        List<String> businessCategories = new ArrayList<>();


        referenceData.ifPresent(reference -> {

            log.info("reference data fetched");

            assertThat(reference).isNotNull();

            businessCategories.add(referenceData.get().getBusinessCategories().get(0));

        });

        log.info("Fetched reference data from the database {}", referenceData);

        advert1.setAdBusinessCategories(businessCategories);

        log.info("Advert object before saving --> {}",advert1);

        //save advert object
        advertRepository.save(advert1);


        Optional<Advert> savedAdvert = advertRepository.findById(advert1.getId());
        savedAdvert.ifPresent(advert -> {
            assertThat(advert).isNotNull();
        });

        log.info("Fetched saved advert --> {}",savedAdvert.isPresent() ? savedAdvert.get() : "");

    }
}