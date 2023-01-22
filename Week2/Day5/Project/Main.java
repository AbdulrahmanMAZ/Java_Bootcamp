package Project;

public class Main {
    public static void main(String[] args) {

        Train train = new Train("SAR-122",60,300,"23:31");
        Car car = new Car("55", 917, 20, "03:00", 2, 30);

        train.display();
        car.display();

    }
}