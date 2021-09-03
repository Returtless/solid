import java.util.Arrays;
import java.util.List;

public class Store {
    private final List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }

    public Store(){
        products = Arrays.asList(new Notebook("Asus", 1000, 10, Rating.EXCELLENT, "asus"),
                new Television("LG", 600, 2, Rating.BAD, "lg"),
                new Notebook("Acer", 1500, 10, Rating.EXCELLENT, "acer"),
                new Smartphone("Xiaomi", 200, 1, Rating.GOOD, "xiaomi"),
                new Notebook("HP", 1200, 5, Rating.POOR, "hp"),
                new Smartphone("Oppo", 500, 13, Rating.EXCELLENT, "oppo"),
                new Television("Samsung", 800, 4, Rating.BAD, "samsung"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductInfo(Product product) {
        return products.get(products.indexOf(product));
    }

    //DRY
    public void print() {
        System.out.println("Список доступных товаров:");
        products.forEach(p -> System.out.println(p.toString() + " в количестве " + p.getStockCount() + " штук"));
    }
}
