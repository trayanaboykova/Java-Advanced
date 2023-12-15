package ExamPreparation.Exam.P03_Halloween;

public class Main {
    public static void main(String[] args) {
        // Initialize the repository
        House house = new House(6);

        // Initialize entities
        Kid firstKid = new Kid("Yoana", 10, "Osogovska");
        Kid secondKid = new Kid("Lily", 5, "Pirina");
        Kid thirdKid = new Kid("Anna", 7, "Pirotska");
        Kid fourthKid = new Kid("Selin", 8, "Solunska");

        // Test adding kids
        house.addKid(firstKid);
        house.addKid(secondKid);
        house.addKid(thirdKid);
        house.addKid(fourthKid);

        // Print the kids
        System.out.println("Kids in the house:");
        System.out.println(house.getStatistics());

        // Test removing kids
        System.out.println("Removing kid named Yoana: " + house.removeKid("Yoana")); // true
        System.out.println("Removing kid named Sara: " + house.removeKid("Sara"));   // false

        // Get a kid by street
        Kid kid = house.getKid("Pirotska");
        if (kid != null) {
            System.out.println("Kid found on Pirotska street: " + kid);
        } else {
            System.out.println("No kid found on Pirotska street.");
        }

        // Get the total number of kids
        System.out.println("Total number of kids in the house: " + house.getAllKids());

        // Additional Tests

        // Capacity boundary tests
        System.out.println("\nCapacity boundary tests:");
        House smallHouse = new House(1);
        smallHouse.addKid(firstKid);
        smallHouse.addKid(secondKid); // Shouldn't be added
        System.out.println("Kids in the small house: " + smallHouse.getAllKids()); // 1

        System.out.println("\nNull values tests:");
        try {
            house.addKid(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Attempted to add a null kid: " + e.getMessage());
        }

        // Duplicate kids tests
        System.out.println("\nDuplicate kids tests:");
        House dupHouse = new House(5);
        dupHouse.addKid(firstKid);
        dupHouse.addKid(firstKid);
        System.out.println("Kids in the duplicate house: " + dupHouse.getAllKids()); // 2

        // Removing with different casing
        System.out.println("\nRemoving with different casing:");
        System.out.println("Removing kid named YOANA: " + dupHouse.removeKid("YOANA")); // false

        // Empty house statistics format
        System.out.println("\nEmpty house statistics format:");
        House emptyHouse = new House(5);
        System.out.println(emptyHouse.getStatistics());

        // Case-sensitive street retrieval
        System.out.println("\nCase-sensitive street retrieval:");
        Kid caseKid1 = new Kid("John", 9, "Pirotska");
        Kid caseKid2 = new Kid("Doe", 11, "pirotska");
        house.addKid(caseKid1);
        house.addKid(caseKid2);
        System.out.println(house.getKid("Pirotska"));  // should retrieve John
        System.out.println(house.getKid("pirotska"));  // should retrieve Doe

// Removing from empty house
        System.out.println("\nRemoving from empty house:");
        House anotherEmptyHouse = new House(10);
        System.out.println(anotherEmptyHouse.removeKid("NonExistentKid"));  // false

// Overcapacity checks
        System.out.println("\nOvercapacity checks:");
        House tinyHouse = new House(2);
        tinyHouse.addKid(firstKid);
        tinyHouse.addKid(secondKid);
        tinyHouse.addKid(thirdKid);  // shouldn't be added due to capacity
        System.out.println(tinyHouse.getAllKids());  // 2
        tinyHouse.removeKid("Yoana");
        tinyHouse.addKid(thirdKid);
        System.out.println(tinyHouse.getAllKids());  // 2

// Statistics after removal
        System.out.println("\nStatistics after removal:");
        house.removeKid("Lily");
        System.out.println(house.getStatistics());

// Edge cases for Kid
        System.out.println("\nEdge cases for Kid:");
        Kid strangeKid = new Kid("123Name!", 10, "@Street?");
        house.addKid(strangeKid);
        System.out.println(house.getKid("@Street?"));

// Multiple kids from the same street
        System.out.println("\nMultiple kids from the same street:");
        Kid kidFromSameStreet1 = new Kid("Jack", 10, "Baker");
        Kid kidFromSameStreet2 = new Kid("Jill", 11, "Baker");
        house.addKid(kidFromSameStreet1);
        house.addKid(kidFromSameStreet2);
        System.out.println(house.getKid("Baker"));  // should retrieve Jack

    }
}