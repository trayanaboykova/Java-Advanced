package ExamsExercises.Exam_22.P03_VendingSystem;

import java.math.BigDecimal;

public class Drink {
    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: $" + price + ", Volume: " + volume + " ml";
    }
}
