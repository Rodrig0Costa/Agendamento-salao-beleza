package br.com.beautystyle.model.entity;

import androidx.room.Entity;

import java.time.LocalTime;

@Entity

public class BlockTimeOnDay extends BlockTime {

    public BlockTimeOnDay() {
        super();
    }

    public BlockTimeOnDay(Long id, LocalTime startTime, LocalTime endTime) {
        super(id, startTime, endTime);
    }

    public void update(BlockTimeOnDay blockTime) {
        blockTime.setEndTime(getEndTime());
        blockTime.setStartTime(getStartTime());
        blockTime.setDate(getDate());
        blockTime.setReason(getReason());
    }
}
