package oncall.utills;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    public static void isDuplication(String userInput) {
        String[] inputArray = userInput.split(",");

        Set<String> uniqueItems = new HashSet<>(Arrays.asList(inputArray));

        if(uniqueItems.size() != inputArray.length){ //한 순번에 중복되어 편성되면 안됨
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static void isOnCallStaff(String weeklyStaff,String holidayStaff) {
        Set<String> weekly = new HashSet<>(Arrays.asList(weeklyStaff.split(",")));
        Set<String> holiday = new HashSet<>(Arrays.asList(holidayStaff.split(",")));
        if(!weekly.equals(holiday)){ //온콜 스태프가 정해져있으니 요소가 일치해야함
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
