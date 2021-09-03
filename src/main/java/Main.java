import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Storage store = new Storage();
        store.print();
        //Вводим данные для фильтрации
        Storage filteredStore = filterStore();
        filteredStore.print();
        //Добавляем фильтрованные товары в корзину
        filteredStore.getProducts().forEach(product -> basket.addToBasket(product, 1));
        //Покупаем товары в корзине
        basket.checkout(store);
        //Очищаем фильтр
        filteredStore.getProducts().clear();
    }

    private static Storage filterStore() {
        Storage filteredStore = new Storage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            filteredStore.print();
            System.out.printf("Выберите фильтр для товаров (введите номер) %n %d. %s%n %d. %s%n %d. %s%n или любой другой символ для выхода",
                    Characteristics.TYPE.ordinal(), Characteristics.TYPE,
                    Characteristics.PRICE.ordinal(), Characteristics.PRICE,
                    Characteristics.RATING.ordinal(), Characteristics.RATING);
            try {
                int number = scanner.nextInt();
                switch (Characteristics.fromInt(number)) {
                    case TYPE -> {
                        System.out.printf("Выберите категорию товаров(введите номер) %n %d. %s %n %d. %s%n %d. %s%n",
                                Category.NOTEBOOK.ordinal(), Category.NOTEBOOK, Category.SMARTPHONE.ordinal(), Category.SMARTPHONE, Category.TELEVISION.ordinal(), Category.TELEVISION);
                        number = scanner.nextInt();
                        filteredStore = new StoreBuilder(filteredStore.getProducts()).filterByType(Category.fromInt(number)).build();
                    }
                    case RATING -> {
                        System.out.printf("Выберите рейтинг товаров(введите номер) %n %d. %s %n %d. %s%n %d. %s%n %d. %s%n %d. %s%n",
                                Rating.BAD.ordinal(), Rating.BAD, Rating.POOR.ordinal(), Rating.FAIR, Rating.FAIR.ordinal(), Rating.FAIR, Rating.GOOD.ordinal(), Rating.GOOD, Rating.EXCELLENT.ordinal(), Rating.EXCELLENT);
                        number = scanner.nextInt();
                        filteredStore = new StoreBuilder(filteredStore.getProducts()).filterByRating(Rating.fromInt(number)).build();
                    }
                    case PRICE -> {
                        System.out.println("Введите максимальную стоимость товара:");
                        double maxPrice = scanner.nextInt();
                        filteredStore = new StoreBuilder(filteredStore.getProducts()).filterByPrice(maxPrice, false).build();
                    }
                }
            } catch (Exception e) {
                break;
            }
        }
        return filteredStore;
    }
}