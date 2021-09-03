//Liskov substitution principle
public class Television extends Product {
    private String otherTelevisionCharacteristics;

    public Television(String name, double price, int stockCount, Rating rating, String otherCharacteristics) {
        super(name, price, stockCount, rating, Category.TELEVISION);
        this.otherTelevisionCharacteristics = otherCharacteristics;
    }

    public String getOtherTelevisionCharacteristics() {
        return otherTelevisionCharacteristics;
    }

    public void setOtherTelevisionCharacteristics(String otherTelevisionCharacteristics) {
        this.otherTelevisionCharacteristics = otherTelevisionCharacteristics;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Характеристики телевизора: %s", otherTelevisionCharacteristics);
    }
}
