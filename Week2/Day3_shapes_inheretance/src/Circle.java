public class Circle extends Shape{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.pow(radius,2) * 3.14;
    }
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public String toString() {
//        return "Circle{" +
//                "radius=" + radius +
//                ", which is subclass of:" + super.toString()+
//                '}';
        return "A Circle with radius="+ radius +", which is a subclass of " +super.toString();

    }
}
