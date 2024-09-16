package Ders16.home;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("Apple", 10);
        fruits.put("Banana", 5);
        fruits.put("Cherry", 20);
        System.out.println(fruits.get("Apple"));  // Output: 10
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
