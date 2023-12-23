package com.henry.piSpringBoot.dao.dto;

public class ExpenseDto {
    private String date;
    private String description;
    private Double amount;
    private Long categoryId;
    private String categoryName;

    public ExpenseDto() {
    }

    public ExpenseDto(String date, String description, Double amount, Long categoryId, String categoryName) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.categoryId = categoryId;
        this.categoryName = categoryName;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
};

