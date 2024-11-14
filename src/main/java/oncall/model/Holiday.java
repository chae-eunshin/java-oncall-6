package oncall.model;

import java.util.List;
import java.util.Map;

public class Holiday {
    private final List<Map<String, Integer>> holidayMonth = List.of(
            Map.of("month", 1, "day", 1),
            Map.of("month", 3, "day", 1),
            Map.of("month", 5, "day", 5),
            Map.of("month", 6, "day", 6),
            Map.of("month", 8, "day", 15),
            Map.of("month", 10, "day", 3),
            Map.of("month", 10, "day", 9),
            Map.of("month", 12, "day", 25)
    );

    public List<Map<String, Integer>> getHolidayMonth() {
        return holidayMonth;
    }
}
