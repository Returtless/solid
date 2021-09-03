public enum Characteristics {
    TYPE,
    PRICE,
    RATING;


    public static Characteristics fromInt(int index) {
        return switch (index) {
            case 0 -> TYPE;
            case 1 -> PRICE;
            default -> RATING;
        };
    }
}
