package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OncallStaffManager {
    private List<String> weekdayStaff;
    private List<String> holidayStaff;

    public OncallStaffManager(String weekdayStaff, String holidayStaff) {
        this.weekdayStaff = Arrays.asList(weekdayStaff.split(","));
        this.holidayStaff = Arrays.asList(holidayStaff.split(","));
    }

    public List<String> getWeekdayStaff() {
        return weekdayStaff;
    }

    public List<String> getHolidayStaff() {
        return holidayStaff;
    }

    public String getTodayOncallStaff( String day,int order) {
        if (day.contains("휴일") || day.equals("토") || day.equals("일")) {
            return holidayStaff.get(order % holidayStaff.size()+1);//그 다음 순서를 불러오기
        }
        return weekdayStaff.get(order % weekdayStaff.size()+1);
    }
}
