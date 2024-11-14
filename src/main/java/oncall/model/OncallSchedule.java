package oncall.model;

import java.time.LocalDate;

public class OncallSchedule {
    private final int month;
    private final String startDay;

    public OncallSchedule(int month, String startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public int getMonth() {
        return month;
    }

    public String getStartDay() {
        return startDay;
    }

    public int getLengthOfMonth(){
        LocalDate newDate = LocalDate.of(2023, month,1);
        return newDate.lengthOfMonth();
    }
}
