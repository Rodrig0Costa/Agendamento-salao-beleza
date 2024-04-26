package br.com.beautystyle.retrofit.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.beautystyle.database.references.EventWithClientAndJobs;
import br.com.beautystyle.model.entity.BlockTime;

public class EventWithClientAndJobsDto {

    private List<EventWithClientAndJobs> events;
    private BlockTimeDto blockTimes;

    public EventWithClientAndJobsDto() {
        events = new ArrayList<>();
        blockTimes = new BlockTimeDto();
    }

    public EventWithClientAndJobsDto(List<EventWithClientAndJobs> events, BlockTimeDto blockTimes) {
        this.events = events;
        this.blockTimes = blockTimes;
    }

    public List<EventWithClientAndJobs> getEvents() {
        return events;
    }

    public void setEvents(List<EventWithClientAndJobs> events) {
        this.events = events;
    }

    public BlockTimeDto getBlockTimes() {
        return blockTimes;
    }

    public void setBlockTimes(BlockTimeDto blockTimes) {
        this.blockTimes = blockTimes;
    }
}
