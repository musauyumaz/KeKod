package classes;

public class TurtleJava {

    public TurtleJava() {
    }

    public TurtleJava(int feetCount) {
        this.feetCount = feetCount;
    }

    public TurtleJava(String name) {
        this.name = name;
    }

    public TurtleJava(int feetCount, String name) {
        this.feetCount = feetCount;
        this.name = name;
    }

    int feetCount = 4;
    String feetColor = "Brown";
    int headCount = 1;
    String headColor = "Brown";
    String shelterColor = "Green";
    int tailCount = 1;
    String tailColor = "Brown";
    int age = 1;
    String name = "Tosbik";
    String sex = "Female";
    boolean isMarried = true;

    String makeASount() {
        return "sadsadsa";
    }

    void eatMeal() {

    }

    void walk() {

    }

    void swim() {

    }

    public static void main(String[] args) {
        TurtleJava turtleJavaZero = new TurtleJava();
        TurtleJava turtleJavaOne = new TurtleJava(4);
        TurtleJava turtleJavaTwo = new TurtleJava(4, "Murtle");
    }

}
