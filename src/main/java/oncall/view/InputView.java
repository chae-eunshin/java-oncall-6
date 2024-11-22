package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readInput(String requestMessage) {
        System.out.println(requestMessage);
        return Console.readLine();
    }

}
