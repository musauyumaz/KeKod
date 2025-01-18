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

    private int feetCount = 4;
    private String feetColor = "Brown";
    private int headCount = 1;
    private String headColor = "Brown";
    private String shelterColor = "Green";
    private int tailCount = 1;
    private String tailColor = "Brown";
    private int age = 1;
    private String name = "Tosbik";
    private String sex = "Female";
    private boolean isMarried = true;

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
