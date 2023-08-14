package app.services;

import app.data.Product;

import java.util.List;

public class DataService {
    // Алгоритм бінарного пошуку
    public static int binarySearch(List<Product> list, double x) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            double midPrice = list.get(mid).price();

            if (midPrice == x) {
                return list.indexOf(list.get(mid));
            } else if (midPrice < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
