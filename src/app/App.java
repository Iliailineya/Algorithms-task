package app;

import app.data.DataProvider;
import app.data.Product;
import app.services.DataService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) {
        getOutput(DataProvider.getData());
    }

    private static double getSearchValue() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter price value to search (x.xx): ");
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid value. Please enter a valid number.");
            }
        }
    }

    private static void getInitialData(List<Product> list) {
        System.out.print("Initial data:\n");
        AtomicInteger count = new AtomicInteger();

        list.forEach(product ->
                System.out.printf("%d) %s, USD %s%n", count.getAndIncrement(), product.name(), product.price()));
    }

    private static void getOutput(List<Product> list) {
        int index = DataService.binarySearch(list, getSearchValue());

        getInitialData(list);

        System.out.println("------------------------");
        System.out.print(index == -1 ? "No data.\n" : "Product: %s, USD %s\n".formatted(list.get(index).name(), list.get(index).price()));
    }

}
