package br.com.beautystyle.agendamento.service;

import br.com.beautystyle.agendamento.config.security.TokenServices;
import br.com.beautystyle.agendamento.controller.dto.*;
import br.com.beautystyle.agendamento.controller.form.ScheduleByProfessionalForm;
import br.com.beautystyle.agendamento.model.entity.Job;
import br.com.beautystyle.agendamento.model.entity.Schedule;
import br.com.beautystyle.agendamento.util.EventTimeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScheduleByProfessionalService {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private EventTimeByProfessionalService eventTimeService;
    @Autowired
    private EventTimeComponent eventTimeComponent;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JobService jobService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TokenServices tokenServices;

    public ScheduleByProfessionalDto findAllByDate(LocalDate date) {

        Long tenant = tokenServices.getTenant(request);

        BlockTimeDto blockTimes = eventTimeComponent.getBlockTimesDto(date, tenant);

        List<Schedule> schedules = scheduleService.findByDateAndTenant(date, tenant);

        List<EventDto> events = EventDto.convert(schedules);

        return new ScheduleByProfessionalDto(blockTimes, events);
    }

    public EventDto insert(ScheduleByProfessionalForm eventForm) {

        Long tenant = tokenServices.getTenant(request);

        Set<Job> jobs = jobService.findAllById(eventForm.getJobs().stream().map(JobDto::getApiId).collect(Collectors.toList()));

        Schedule schedule = new Schedule(eventForm, jobs, tenant);

        ResponseEntity<?> responseEntityStatusConflict = eventTimeService.checkEventTimeIsAvailable(
                schedule, schedule.getDate());
        if (responseEntityStatusConflict != null)
            return (EventDto) responseEntityStatusConflict.getBody();

        EventDto eventDto = new EventDto(scheduleService.save(schedule));

        return responseEntityStatusCreated(eventDto);

    }

    private EventDto responseEntityStatusCreated(EventDto eventDto) {
        return eventDto;
    }

    public ResponseEntity<?> update(ScheduleByProfessionalForm eventForm, Long id) {

        scheduleService.findById(id);

        Long tenant = tokenServices.getTenant(request);

        Set<Job> jobs = jobService.findAllById(eventForm.getJobs().stream().map(JobDto::getApiId).collect(Collectors.toList()));

        Schedule schedule = new Schedule(eventForm, jobs, tenant);
        schedule.setId(id);

        ResponseEntity<?> responseEntityStatusConflict = eventTimeService.checkEventTimeIsAvailable(
                schedule, schedule.getDate());

        if (responseEntityStatusConflict != null)
            return responseEntityStatusConflict;

        scheduleService.updateByProfessional(schedule);

        return ResponseEntity.ok().build();
    }

    public void deleteById(Long id) {

        Schedule schedule = scheduleService.findById(id);

        jobService.removeAssociation(schedule);

        customerService.removeAssociation(schedule);

        scheduleService.deleteById(id);

    }
}
