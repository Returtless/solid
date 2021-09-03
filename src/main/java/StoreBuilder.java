import java.util.List;
import java.util.stream.Collectors;

//Single Responsibility Principle
public class StoreBuilder {
    private List<Product> products;

    public StoreBuilder(List<Product> products) {
        this.products = products;
    }

    public StoreBuilder filterByAvailable() {
        products = products.stream().filter(p -> p.getStockCount() > 0).collect(Collectors.toList());
        return this;
    }

    public StoreBuilder filterByType(Category category) {
        this.products = products.stream().filter(p -> category.equals(p.getCategory())).collect(Collectors.toList());
        return this;
    }

    public StoreBuilder filterByPrice(double price, boolean isGreat) {
        this.products = products.stream().filter(p -> isGreat ? p.getPrice() > price : p.getPrice() < price).collect(Collectors.toList());
        return this;
    }

    public StoreBuilder filterByRating(Rating rating) {
        this.products = products.stream().filter(p -> rating.equals(p.getRating())).collect(Collectors.toList());
        return this;
    }

    public Storage build() {
        if (products == null || products.isEmpty()) {
            throw new IllegalStateException("Список товаров пуст");
        }
        return new Storage(products);
    }
}
