package oncall.view;

import oncall.model.OncallSchedule;
import oncall.model.OncallStaffManager;

public class OutputView {

    public static void printOncallSchedule(OncallSchedule schedule, OncallStaffManager manager) {
        String beforeOncallStaff = "";
        for(int i = 1; i <= schedule.getLengthOfMonth(); i++){
            System.out.println(schedule.getMonth()+"월 "+i+"일 "+schedule.getStartDay()+" "+manager.getTodayOncallStaff("요일",i));
        } //요일은 이넘으로 만들어서 다음 요일을 받아올 수 있도록 하기 그리고 그 스태프의 순서는 전에 출력했던 스태프를 관리해야되네..
    }
}
