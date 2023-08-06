package Course03_SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> atlasMap = new LinkedHashMap<>();
        String input;
        while (num-- > 0) {
            input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            atlasMap.putIfAbsent(continent, new LinkedHashMap<>());
            atlasMap.get(continent).putIfAbsent(country, new ArrayList<>());
            atlasMap.get(continent).get(country).add(city);
        }

        atlasMap.forEach((continent, countries) -> {
            System.out.printf("%s:\n", continent);
            countries.forEach((country, city) ->
                    System.out.printf(" %s -> %s\n", country, String.join(", ", city)));
        });
    }
}
