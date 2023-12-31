package app.data;

import java.util.*;

public class DataProvider {

    public static List<Product> getData() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("apple", 1.29));
        list.add(new Product("banana", 2.05));
        list.add(new Product("plum", 1.79));
        list.add(new Product("mango", 2.75));
        list.sort(Comparator.comparingDouble(Product::price));
        return list;
    }
}


