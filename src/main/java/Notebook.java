//Liskov substitution principle
public class Notebook extends Product {
    private String otherCharacteristics;

    public Notebook(String name, double price, int stockCount, Rating rating, String otherCharacteristics) {
        super(name, price, stockCount, rating, Category.NOTEBOOK);
        this.otherCharacteristics = otherCharacteristics;
    }

    public String getOtherCharacteristics() {
        return otherCharacteristics;
    }

    public void setOtherCharacteristics(String otherCharacteristics) {
        this.otherCharacteristics = otherCharacteristics;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Характеристики ноутбука: %s", otherCharacteristics);
    }
}
