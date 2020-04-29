package com.project.nairon.models.questionnaire;
/*
 *@author tobi
 * created on 25/04/2020
 *
 */

import javax.persistence.*;

@Entity
@Table(name = "question")
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

    @Column(name = "choice")
    private String choice;

    @Column(name = "advert_property")
    private String advertProperty;

    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaireId;


    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPageLevel() {
        return pageLevel;
    }

    public void setPageLevel(Integer order) {
        this.pageLevel = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String option) {
        this.choice = option;
    }

    public String getAdvertProperty() {
        return advertProperty;
    }

    public void setAdvertProperty(String advertProperty) {
        this.advertProperty = advertProperty;
    }

    public Questionnaire getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Questionnaire questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}
