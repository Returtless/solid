//Для отсутствия магических чисел
public enum Rating {
     BAD, POOR, FAIR, GOOD, EXCELLENT;

    public static Rating fromInt(int num) {
        return switch (num) {
            case 0 -> BAD;
            case 1 -> POOR;
            case 3 -> GOOD;
            case 4 -> EXCELLENT;
            default -> FAIR;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case BAD -> "Очень плохо";
            case POOR -> "Неплохо";
            case GOOD -> "Хорошо";
            case EXCELLENT -> "Замечательно";
            default -> "Нормально";
        };
    }
}
