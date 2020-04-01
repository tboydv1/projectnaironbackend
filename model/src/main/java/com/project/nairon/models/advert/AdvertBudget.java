package com.project.nairon.models.advert;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdvertBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertBudgetId;

    private Double budgetAmount;

    private Double budgetBalance;

    private Double budgetPerDay;

    private String standingOrder;

    public Long getAdvertBudgetId() {
        return advertBudgetId;
    }

    public void setAdvertBudgetId(Long advertBudgetId) {
        this.advertBudgetId = advertBudgetId;
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

    public String getStandingOrder() {
        return standingOrder;
    }

    public void setStandingOrder(String standingOrder) {
        this.standingOrder = standingOrder;
    }
}
