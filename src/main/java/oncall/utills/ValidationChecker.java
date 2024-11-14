package oncall.utills;

public class ValidationChecker {

    public static boolean isDividedByComma(String input) {
        if(input.matches("[0-9]+,[가-힣]")){
            return true;
        }
        return false;
    }

    public static boolean isMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static boolean isDay(String day) {
        return day.matches("[월화수목금토일]");
    }
}
