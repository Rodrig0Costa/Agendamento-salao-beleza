package br.com.beautystyle.model.entity;

import java.time.LocalTime;

public class BlockWeekDayTime extends BlockTimeChild {

    private Character dayOfWeek;

    public BlockWeekDayTime() {
        super();
    }

    public BlockWeekDayTime(Long id, LocalTime startTime, LocalTime endTime) {
        super(id, startTime, endTime);
    }

    public Character getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Character dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

}
