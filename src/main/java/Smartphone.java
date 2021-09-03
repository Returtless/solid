//Liskov substitution principle
public class Smartphone extends Product {
    private String otherSmartphoneCharacteristics;

    public Smartphone(String name, double price, int stockCount, Rating rating, String otherCharacteristics) {
        super(name, price, stockCount, rating, Category.SMARTPHONE);
        this.otherSmartphoneCharacteristics = otherCharacteristics;
    }

    public String getOtherSmartphoneCharacteristics() {
        return otherSmartphoneCharacteristics;
    }

    public void setOtherSmartphoneCharacteristics(String otherSmartphoneCharacteristics) {
        this.otherSmartphoneCharacteristics = otherSmartphoneCharacteristics;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Характеристики смартфона: %s", otherSmartphoneCharacteristics);
    }
}
