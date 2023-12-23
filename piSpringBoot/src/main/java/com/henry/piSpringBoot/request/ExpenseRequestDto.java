package com.henry.piSpringBoot.request;

public class ExpenseRequestDto {
    private String date;
    private String description;
    private Double amount;
    private ExpenseCategoryRequestDto categoryRequestDto;

    public ExpenseRequestDto() {
    }

    public ExpenseRequestDto(String date, String description, Double amount, ExpenseCategoryRequestDto categoryRequestDto) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.categoryRequestDto = categoryRequestDto;
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

    public ExpenseCategoryRequestDto getCategoryRequestDto() {
        return categoryRequestDto;
    }

    public void setCategoryRequestDto(ExpenseCategoryRequestDto categoryRequestDto) {
        this.categoryRequestDto = categoryRequestDto;
    }

    @Override
    public String toString() {
        return "ExpenseRequestDto{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", categoryRequestDto=" + categoryRequestDto +
                '}';
    }
}
