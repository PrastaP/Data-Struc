// Color.java
enum Color {
    PURPLE, BLUE, GREEN,RED, SILVER, GOLD
}
// Model.java
enum Model {
    SEDAN,CONVERTIBLE, MINIVAN,SUV, TRUCK,COUPE
}
// Car.java
public class Car {
    private int year;
    private Model model;
    private Color color;
    public Car(int year, Model model, Color color) {
        this.year = year;
        this.model = model;
        this.color = color;
    }
    public void display() {
        System.out.println("Car is a " + year + " " + color + " " + model);
    }
}
// CarDemo.java
class CarDemo {
    public static void main(String[] args) {
        Car firstCar = new Car(2021, Model.MINIVAN, Color.BLUE);
        Car secondCar = new Car(2024, Model.CONVERTIBLE, Color.RED);
        firstCar.display();
        secondCar.display();
    }
}
