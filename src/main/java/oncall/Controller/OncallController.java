package oncall.Controller;

import oncall.model.OncallSchedule;
import oncall.model.OncallStaffManager;
import oncall.utills.ValidationChecker;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OncallController {

    public OncallController(){

    }

    public void run(){
        String[] monthDayInputs= hadleMonthDay();
        OncallSchedule oncallSchedule = new OncallSchedule(Integer.parseInt(monthDayInputs[0]),monthDayInputs[1]);
        String [] oncallStaffs = hadleOncallWeekDayStaff();
        OncallStaffManager oncallStaffManager = new OncallStaffManager(oncallStaffs[0],oncallStaffs[1] );
        OutputView.printOncallSchedule(oncallSchedule, oncallStaffManager);
    }

    private String[] hadleMonthDay(){
        while(true){
            try {
                String monthDayInput = InputView.readInput("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
                ValidationChecker.isDividedByComma(monthDayInput);
                String [] inputList = monthDayInput.split(",");
                ValidationChecker.isMonth(Integer.parseInt(inputList[0]));
                ValidationChecker.isDay(inputList[1]);
                return inputList;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] hadleOncallWeekDayStaff(){
        while(true){
            try {
                String weekdayStaffInput = InputView.readInput("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
                ValidationChecker.isDuplication(weekdayStaffInput);
                String holidayStaffInput = InputView.readInput("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>");
                ValidationChecker.isDuplication(holidayStaffInput);
                ValidationChecker.isOnCallStaff(weekdayStaffInput,holidayStaffInput);
                return new String[] {weekdayStaffInput,holidayStaffInput};
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
