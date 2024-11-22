package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class OncallStaffManager {
    private final List<String> weekdayStaff;
    private final List<String> holidayStaff;
    private final List<String> oncallStaff;
    private int swapTime = 0;
    private Stack<Integer> weekdayLastIndexStack;
    private Stack<Integer> holidayLastIndexStack;

    public OncallStaffManager(String weekdayStaff, String holidayStaff) {
        this.weekdayStaff = Arrays.asList(weekdayStaff.split(","));
        this.holidayStaff = Arrays.asList(holidayStaff.split(","));
        this.oncallStaff = new ArrayList<>();
        this.weekdayLastIndexStack = new Stack<>();
        this.holidayLastIndexStack = new Stack<>();

       //지금 순서나 휴일 주중 스태프 불러오는 에러가 처음에 포멧팅 하는 단계에서 나는 에러는 아님
    }

    public List<String> getWeekdayStaff() {
        return weekdayStaff;
    }

    public List<String> getHolidayStaff() {
        return holidayStaff;
    }

    public String getTodayOncallStaff(String day, int order) {
        if (day.contains("휴일") || day.equals("토") || day.equals("일")) {
            String staff = holidayStaff.get(order % holidayStaff.size());
            if (!isYesterDayStaff(staff)) {
                oncallStaff.add(staff);
                holidayLastIndexStack.push(order % holidayStaff.size());
                return staff;
            }
        }
        String staff = weekdayStaff.get(order % weekdayStaff.size());
        if (!isYesterDayStaff(staff)) {
            oncallStaff.add(staff);
            weekdayLastIndexStack.push(order % weekdayStaff.size());
            return staff;
        }
        return "";
    }

    public int getOncallStaffOrder(String day) {
        try {
            if (day.contains("휴일") || day.contains("토") || day.contains("일")) {
                return holidayLastIndexStack.lastElement(); //그니까 이 메서드는 해당 스태프의 위치를 찾아내서 인덱스를 알려주는 거임
                //이 메서드의 문제는 거기서 시작이 되는 거지 평일이 이어지거나 주말이 이어지면 문제가 없어
                //근데 주말에서 평일로 바뀌면 사실 이렇게 구현을 하면 안됨 왜냐 내가 넘겨주는 건 주말의 다음 사람 순서니까
                //문제가 뭔지 알아냈다!!! 그럼 순서를 리턴해줄 때 아예1을 더한 순서 말고
            }
            return weekdayLastIndexStack.lastElement();
        }catch (NoSuchElementException e){
            return -1;
        }
    }

    private boolean isYesterDayStaff(String staff) {
        if (oncallStaff.isEmpty()) {
            return false;
        }
        return staff.equals(oncallStaff.get(oncallStaff.size() - 1));
    }

    public String handleOncallStaff(String day) {
        if (oncallStaff.isEmpty()) {
            return getTodayOncallStaff(day, 0);
        }
//        if (getTodayOncallStaff(day, getOncallStaffOrder(day, oncallStaff.get(oncallStaff.size() - 1)) + 1).isEmpty()) {
//            if (swapTime == 0) {
//                int currentOrder = getOncallStaffOrder(day, oncallStaff.get(oncallStaff.size() - 1)) + 1;
//                swap(day, currentOrder, currentOrder + 1);
//                swapTime++;//스왑한다음에
//                return getTodayOncallStaff(day, currentOrder);
//            }
//        }
        String oncallStaffName = getTodayOncallStaff(day,
                getOncallStaffOrder(day) + 1);
//        if (swapTime == 1) { //이렇게 되면 위에서 스왑하고 바로 제자리로 돌려놓는게 되는건데
//            swap(day, getOncallStaffOrder(day, oncallStaff.get(oncallStaff.size() - 1)),
//                    getOncallStaffOrder(day, oncallStaff.get(oncallStaff.size() - 1)) + 1);
//            swapTime--;
//        }
        return oncallStaffName;
    }

    private int swap(String day, int i, int j) {
        if (day.contains("휴일") || day.equals("토") || day.equals("일")) {
            String temp = holidayStaff.get(i);
            holidayStaff.set(i, holidayStaff.get(j));
            holidayStaff.set(j, temp);
            return 0;
        }
        String temp = weekdayStaff.get(i);
        weekdayStaff.set(i, weekdayStaff.get(j));
        weekdayStaff.set(j, temp);
        return 0;
    }
}
