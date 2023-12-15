package ExamPreparation.Exam.P03_Halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final int capacity;
    private final List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (kid == null) {
            throw new IllegalArgumentException("Kid cannot be null.");
        }
        if (data.size() < capacity) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        if (name == null) {
            return false;
        }
        return data.removeIf(kid -> kid.getName().equalsIgnoreCase(name));
    }

    public Kid getKid(String street) {
        for (Kid kid : data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder result = new StringBuilder("Children who visited a house for candy:");
        for (Kid kid : data) {
            result.append(System.lineSeparator()).append("\t").append(kid.toString());
        }
        return result.toString();
    }
}