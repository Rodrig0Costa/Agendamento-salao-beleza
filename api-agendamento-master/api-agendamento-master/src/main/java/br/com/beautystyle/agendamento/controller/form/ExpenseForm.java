package br.com.beautystyle.agendamento.controller.form;

import br.com.beautystyle.agendamento.model.entity.Category;
import br.com.beautystyle.agendamento.model.entity.Expense;
import br.com.beautystyle.agendamento.repository.ExpenseRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseForm {

    private String description;
    @NotNull
    private BigDecimal value;
    @NotNull
    private LocalDate expenseDate;
    @NotNull
    private String category;
    @NotNull
    private boolean repeat;
    @JsonIgnore
    private Long tenant;

    public ExpenseForm() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public Long getTenant() {
        return tenant;
    }

    public void setTenant(Long tenant) {
        this.tenant = tenant;
    }

    public Expense update(ExpenseRepository expenseRepository, Long id, Category category) {
        Expense expense = expenseRepository.getById(id);
        expense.setDate(this.expenseDate);
        expense.setValue(this.value);
        expense.setDescription(this.description);
        expense.setCategory(category);
        expense.setRepeat(this.repeat);
        return expense;
    }
}
