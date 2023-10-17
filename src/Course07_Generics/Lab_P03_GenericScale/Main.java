package Course07_Generics.Lab_P03_GenericScale;

public class Main {
    public static void main(String[] args) {


        Scale<Integer> scale = new Scale<>(5, 6);

        Scale<String> stringScale = new Scale<>("A", "B");

        System.out.println(scale.getHeavier());
        System.out.println(stringScale.getHeavier());
    }
}

