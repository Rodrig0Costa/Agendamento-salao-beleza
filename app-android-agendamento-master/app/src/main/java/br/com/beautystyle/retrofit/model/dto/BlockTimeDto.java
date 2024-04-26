package br.com.beautystyle.retrofit.model.dto;



import java.util.ArrayList;
import java.util.List;

import br.com.beautystyle.model.entity.BlockTime;
import br.com.beautystyle.model.entity.BlockTimeEveryDay;
import br.com.beautystyle.model.entity.BlockWeekDayTime;

public class BlockTimeDto {

    private List<BlockWeekDayTime> blockWeekDayTimes;
    private List<BlockTime> blockTimesOnDay = new ArrayList<>();
    private List<BlockTimeEveryDay> blockTimesEveryDay;

    public BlockTimeDto() {
    }

    public List<BlockWeekDayTime> getBlockWeekDayTimes() {
        return blockWeekDayTimes;
    }

    public void setBlockWeekDayTimes(List<BlockWeekDayTime> blockWeekDayTimes) {
        this.blockWeekDayTimes = blockWeekDayTimes;
    }

    public List<BlockTime> getBlockTimesOnDay() {
        return blockTimesOnDay;
    }

    public void setBlockTimesOnDay(List<BlockTime> blockTimesOnDay) {
        this.blockTimesOnDay = blockTimesOnDay;
    }

    public List<BlockTimeEveryDay> getBlockTimesEveryDay() {
        return blockTimesEveryDay;
    }

    public void setBlockTimesEveryDay(List<BlockTimeEveryDay> blockTimesEveryDay) {
        this.blockTimesEveryDay = blockTimesEveryDay;
    }
}
