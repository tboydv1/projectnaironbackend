package com.project.nairon.models.questionnaire;
/*
 *@author tobi
 * created on 25/04/2020
 *
 */

import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Data
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "question")
    private String question;

    @Column(name = "page_level")
    private Integer pageLevel;

    @Column(name = "description")
    private String description;

    @Column(name = "advert_property")
    private String advertProperty;

    @ElementCollection
    @CollectionTable(name = "question_options",joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "choice")
    private List<String> choices;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaireId;




}
