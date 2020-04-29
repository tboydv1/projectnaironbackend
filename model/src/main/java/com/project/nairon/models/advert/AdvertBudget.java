package com.project.nairon.models.advert;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author tobi
 */

@Entity
@Table(name="advert_budget")
public class AdvertBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer budgetId;
    private Double budgetAmount;
    private Double budgetBalance;
    private Double budgetPerDay;
    private Date startDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advert_id")
    private Advert advert;

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer id) {
        this.budgetId = id;
    }

    public Double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public Double getBudgetBalance() {
        return budgetBalance;
    }

    public void setBudgetBalance(Double budgetBalance) {
        this.budgetBalance = budgetBalance;
    }

    public Double getBudgetPerDay() {
        return budgetPerDay;
    }

    public void setBudgetPerDay(Double budgetPerDay) {
        this.budgetPerDay = budgetPerDay;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdvertBudget{");
        sb.append("budgetId=").append(budgetId);
        sb.append(", budgetAmount=").append(budgetAmount);
        sb.append(", budgetBalance=").append(budgetBalance);
        sb.append(", budgetPerDay=").append(budgetPerDay);
        sb.append(", startDate=").append(startDate);
        sb.append(", advert=").append(advert);
        sb.append('}');
        return sb.toString();
    }
}
