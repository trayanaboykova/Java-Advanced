package ExamsExercises.Exam_22.P03_VendingSystem;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (drinks.size() < buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        Drink drinkToRemove = null;
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                drinkToRemove = drink;
                break;
            }
        }
        if (drinkToRemove != null) {
            drinks.remove(drinkToRemove);
            return true;
        }
        return false;
    }

    public Drink getLongest() {
        Drink longestDrink = null;
        for (Drink drink : drinks) {
            if (longestDrink == null || drink.getName().length() > longestDrink.getName().length()) {
                longestDrink = drink;
            }
        }
        return longestDrink;
    }

    public Drink getCheapest() {
        Drink cheapestDrink = drinks.get(0);
        for (Drink drink : drinks) {
            if (drink.getPrice().compareTo(cheapestDrink.getPrice()) < 0) {
                cheapestDrink = drink;
            }
        }
        return cheapestDrink;
    }


    public String buyDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                drinks.remove(drink);
                return drink.toString();
            }
        }
        return null;
    }

    public String report() {
        StringBuilder reportBuilder = new StringBuilder("Drinks available:\n");
        for (Drink drink : drinks) {
            reportBuilder.append(drink).append("\n");
        }
        return reportBuilder.toString().trim();
    }
}
