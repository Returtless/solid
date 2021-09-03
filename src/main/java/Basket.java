import java.util.HashMap;
import java.util.Map;

//Open-closed principle
public class Basket implements Store {

    private final Map<Product, Integer> productList;

    public Basket() {
        productList = new HashMap<Product, Integer>();
    }

    public void addToBasket(Product product, int count) {
        if (product.getStockCount() >= count) {
            productList.put(product, count);
        } else {
            System.out.printf("Невозможно добавить %s в корзину в количестве %d штук. В наличии: %d%n", product.getName(), count, product.getStockCount());
        }
    }

    public void removeFromBasket(Product product) {
        productList.remove(product);
    }

    public void decreaseCountOfProduct(Product product) {
        productList.computeIfPresent(product, (k, v) -> v--);
    }

    public void increaseCountOfProduct(Product product) {
        productList.computeIfPresent(product, (k, v) -> v++);
    }

    public void checkout(Storage store) {
        System.out.println("Вы купили товары:");
        productList.forEach((k, v) -> {
            store.getProducts().get(store.getProducts().indexOf(k)).changeStockCount(v);
            System.out.println(k.getName() + " в количестве " + v + " штук");
        });
    }

    @Override
    public void print() {
        System.out.println("Список товаров в корзине:");
        productList.forEach((k, v) -> System.out.println(k.toString() + " в количестве " + v + " штук"));
    }

    @Override
    public void getProductInfo(Product product) {
        System.out.println(product);
    }
}
