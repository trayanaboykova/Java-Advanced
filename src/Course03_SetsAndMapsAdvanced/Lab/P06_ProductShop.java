package Course03_SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> storeInfoMap = new TreeMap<>();
        String input;
        while (!(input = scanner.nextLine()).equals("Revision")) {

            String store = input.split(",\\s+")[0];
            String product = input.split(",\\s+")[1];
            double price = Double.parseDouble(input.split(",\\s+")[2]);

            storeInfoMap.putIfAbsent(store, new LinkedHashMap<>());
            storeInfoMap.get(store).putIfAbsent(product, price);
        }

        storeInfoMap.forEach((store, productInfo) -> {
            System.out.printf("%s->\n", store);
            productInfo.forEach((product, price) ->
                    System.out.printf("Product: %s, Price: %.1f\n", product, price));
        });
    }
}

