package com.project.nairon.models.advert;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author tobi
 */

@Entity
@Table(name="advert_budget")
@Data
public class AdvertBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer budgetId;
    private Double budgetAmount;
    private Double budgetBalance;
    private Double budgetPerDay;
    private Date startDate;

    @OneToOne(mappedBy = "advertBudget", cascade={CascadeType.ALL})
    @ToString.Exclude
    private Advert advert;


    public AdvertBudget(){

        budgetBalance = 0.0;
    }

}
