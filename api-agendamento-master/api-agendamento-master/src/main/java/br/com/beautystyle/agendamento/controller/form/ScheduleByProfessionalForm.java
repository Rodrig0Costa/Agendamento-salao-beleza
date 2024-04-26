package br.com.beautystyle.agendamento.controller.form;

import br.com.beautystyle.agendamento.controller.dto.JobDto;
import br.com.beautystyle.agendamento.controller.dto.ScheduleByCostumerDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ScheduleByProfessionalForm {

    @NotNull
    private Long customerId;
    @NotNull
    @NotEmpty
    private List<JobDto> jobs;
    @NotNull
    private ScheduleByCostumerDto event;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDto> jobs) {
        this.jobs = jobs;
    }

    public ScheduleByCostumerDto getEvent() {
        return event;
    }

    public void setEvent(ScheduleByCostumerDto event) {
        this.event = event;
    }
}
