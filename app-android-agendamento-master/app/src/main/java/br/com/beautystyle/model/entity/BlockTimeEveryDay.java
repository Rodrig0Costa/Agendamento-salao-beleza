package br.com.beautystyle.model.entity;


import androidx.room.Entity;

import java.time.LocalTime;

@Entity
public class BlockTimeEveryDay extends BlockTimeChild {

    public BlockTimeEveryDay() {
        super();
    }

    public BlockTimeEveryDay(Long id, LocalTime startTime, LocalTime endTime) {
        super(id, startTime, endTime);
    }

}
