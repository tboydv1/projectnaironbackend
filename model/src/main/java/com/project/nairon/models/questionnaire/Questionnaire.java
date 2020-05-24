package com.project.nairon.models.questionnaire;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author tobi
 */

@Entity
@Data
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionnaireId;
    private Integer maxPages;
    private String type;


}
