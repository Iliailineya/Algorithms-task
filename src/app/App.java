package app;

import app.data.DataProvider;
import app.data.Product;
import app.services.DataService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class App {

    public static void main(String[] args) {
        double priceSearch = getSearchValue();
        double priceSearc1h = getSearchValue();
        List<Product> list = DataProvider.getData();
        getInitialData(list);
        int index = DataService.binarySearch(list, priceSearch);
        getOutput(list, priceSearch, index);
    }

    private static double getSearchValue() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter price value to search (x.xx): ");
            return Double.parseDouble(scanner.next());
        }
    }

    private static void getInitialData(List<Product> list) {
        System.out.print("Initial data:\n");
        AtomicInteger count = new AtomicInteger();

        list.forEach(product ->
                System.out.printf("%d) %s, USD %s%n", count.getAndIncrement(), product.name(), product.price()));
    }

    private static void getOutput(List<Product> list, double priceSearch, int index) {
        System.out.println("------------------------");
        System.out.printf(index == -1 ? "No data.%n" : "Product: %s, USD %s%n", index != -1 ? list.get(index).name() : "", priceSearch);
    }
}
