package oncall.Controller;

import oncall.view.InputView;

public class OncallController {
//    private final InputView inputView;

    public OncallController(){
//        inputView = new InputView();
    }

    public void run(){
        InputView.readInput("비상 근무를 배정할 월과 시작 요일을 입력하세요>");
    }
}
