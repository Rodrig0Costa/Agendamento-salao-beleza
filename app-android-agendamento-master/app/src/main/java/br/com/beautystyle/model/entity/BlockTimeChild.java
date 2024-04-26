package br.com.beautystyle.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class BlockTimeChild  extends BlockTime{

    private LocalDate endDate;

    private List<LocalDate> exceptionDates = new ArrayList<>();

    public BlockTimeChild() {
    }

    public BlockTimeChild(Long id, LocalTime startTime, LocalTime endTime) {
        super(id, startTime, endTime);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<LocalDate> getExceptionDates() {
        return exceptionDates;
    }

    public void setExceptionDates(List<LocalDate> exceptionDates) {
        this.exceptionDates = exceptionDates;
    }
}
