package oncall.Controller;

import oncall.utills.ValidationChecker;
import oncall.view.InputView;

public class OncallController {
//    private final InputView inputView;

    public OncallController(){
//        inputView = new InputView();
    }

    public void run(){

        String monthDayInput = InputView.readInput("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
        ValidationChecker.isDividedByComma(monthDayInput);

    }

    private void hadleMonthDay(){
        boolean isDone = false;
        while(!isDone){
            try {
                String monthDayInput = InputView.readInput("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
                isDone= ValidationChecker.isDividedByComma(monthDayInput);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
