package ExamsExercises.Exam_16.P03_ElephantSanctuary;

public class Elephant {

    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRetiredFrom() {
        return this.retiredFrom;
    }

    public void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", this.name, this.age, this.retiredFrom);
    }
}
