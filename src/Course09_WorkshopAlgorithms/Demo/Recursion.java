package Course09_WorkshopAlgorithms.Demo;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(fact(6));

    }

    public static int fact(int n) {
        //!!! дъно !!!
        if (n == 0) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }
}
