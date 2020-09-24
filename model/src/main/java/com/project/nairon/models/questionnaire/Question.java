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
    private Integer id;

    private String question;

    private Integer pageLevel;

    private String description;

    private String advertProperty;

    @ElementCollection
    @CollectionTable(name = "question_options",joinColumns = @JoinColumn(name = "question_id"))
    private List<String> choices;

    @ManyToOne
    @JoinColumn()
    private Questionnaire questionnaireId;




}
