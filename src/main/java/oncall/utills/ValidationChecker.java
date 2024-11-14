package oncall.utills;

public class ValidationChecker {

    public static void isDividedByComma(String input) {
        if(!input.matches("[0-9]+,[가-힣]")){
            throw new IllegalArgumentException("[ERROR] 월과 시작 요일은 ,로 구분하여 입력해주세요");
        }
    }

    public static void isMonth(int month) {
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("[ERROR] 월은 1월부터 12월 안에서 입력할 수 있습니다.");
        }
    }

    public static void isDay(String day) {
        if(!day.matches("[월화수목금토일]")){
            throw new IllegalArgumentException("[ERROR] 요일은 월,화,수,목,금,토,일 안에서 입력해주세요");
        }
    }
}
