package oncall.model;

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
}
