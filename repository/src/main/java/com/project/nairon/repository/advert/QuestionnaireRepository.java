package com.project.nairon.repository.advert;
/*
 *@author tobi
 * created on 25/04/2020
 *
 */

import com.project.nairon.models.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "questionnaires", path = "questionnaires")
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Integer> {


}
