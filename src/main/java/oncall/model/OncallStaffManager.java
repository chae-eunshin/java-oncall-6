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
}
