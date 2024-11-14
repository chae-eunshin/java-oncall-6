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

    public int getLengthOfMonth() {
        LocalDate newDate = LocalDate.of(2023, month, 1);
        return newDate.lengthOfMonth();
    }

    public String getTodayOncallStaff(OncallStaffManager oncallStaffManager, String day,int order) {
        if (day.equals("휴일") || day.equals("토") || day.equals("일")) {
            return oncallStaffManager.getHolidayStaff().get(order+1);//그 다음 순서를 불러오기
        }
        return oncallStaffManager.getWeekdayStaff().get(order+1);
    }
}
