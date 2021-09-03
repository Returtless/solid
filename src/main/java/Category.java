//Для отсутствия магических чисел
public enum Category {
    SMARTPHONE, NOTEBOOK, TELEVISION, BASIC;

    public static Category fromInt(int num) {
        return switch (num) {
            case 0 -> SMARTPHONE;
            case 1 -> NOTEBOOK;
            case 2 -> TELEVISION;
            default -> BASIC;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case SMARTPHONE -> "Смартфоны";
            case NOTEBOOK -> "Ноутбуки";
            case TELEVISION -> "Телевизоры";
            default -> "Общее";
        };
    }
}
