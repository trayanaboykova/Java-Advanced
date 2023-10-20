package ExamsExercises.Exam_22.P03_VendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getButtonCapacity() {
        return buttonCapacity;
    }

    public void setButtonCapacity(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public int getCount() {
        return this.drinks.size();
    }

    public void addDrink(Drink drink) {
        if (buttonCapacity > drinks.size()) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return this.drinks.removeIf(d -> d.getName().equals(name));
    }

    public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }

    public String buyDrink(String name) {
        Optional<Drink> drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Drinks available:\n");

        for (Drink drink : drinks) {
            sb.append(drink.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}