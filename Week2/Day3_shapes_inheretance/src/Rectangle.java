public class Rectangle extends Shape{
    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double height) {
        this.length = height;
    }
    public double getArea() {
        return length * width;
    }
    public double getPerimeter() {
        return 2*(length+width);
    }

    @Override
    public String toString() {
//        return "Rectangle{" +
//                "width=" + width +
//                ", length=" + length +
//                ", which is subclass of:" + super.toString()+
//                '}';
        return  "A Rectangle with width="+ width+ "and length="+ length+", which is a subclass of "+super.toString();
    }
}
