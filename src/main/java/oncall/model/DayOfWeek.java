package oncall.model;

public enum DayOfWeek {
    월, 화, 수, 목, 금, 토, 일;

    // 다음 요일을 반환하는 메서드
    public DayOfWeek next() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public DayOfWeek before() {
        int index = (this.ordinal() - 1 + values().length) % values().length;
        return values()[index];
    }
}
