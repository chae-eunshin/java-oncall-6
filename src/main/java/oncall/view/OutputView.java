package oncall.view;

import oncall.model.DayOfWeek;
import oncall.model.OncallSchedule;
import oncall.model.OncallStaffManager;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void printOncallSchedule(OncallSchedule schedule, OncallStaffManager manager) {
        String beforeOncallStaff = "";
        DayOfWeek today = DayOfWeek.valueOf(schedule.getStartDay());
        for(int i = 1; i <= schedule.getLengthOfMonth(); i++){
            System.out.println(schedule.getMonth()+"월 "+i+"일 "+today+" "+manager.handleOncallStaff(today+""));
            today = today.next();
        } //요일은 이넘으로 만들어서 다음 요일을 받아올 수 있도록 하기 그리고 그 스태프의 순서는 전에 출력했던 스태프를 관리해야되네..
    }
}
