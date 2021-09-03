import java.util.Objects;

//Single Responsibility Principle
public class Product {
    private final double price;
    private final String name;
    private int stockCount;
    private final Rating rating;
    private final Category category;

    public Product(String name, double price, int stockCount, Rating rating, Category category) {
        this.price = price;
        this.name = name;
        this.stockCount = stockCount;
        this.rating = rating;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void changeStockCount(int changeCount) {
        this.stockCount -= changeCount;
    }

    public Rating getRating() {
        return rating;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && category == product.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return String.format("Название: %s, Категория: %s, Количество: %d, Цена: %.2f, Рейтинг: %s", name, category, stockCount, price, rating);
    }
}
