package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {

    public static String readInput(String requestMessage) {
        System.out.println(requestMessage);
        return Console.readLine();
    }

}
