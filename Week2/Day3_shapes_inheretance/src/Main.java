public class Main {
    public static void main(String[] args) {
        //Square
        Square square = new Square("black",true,71);
        System.out.println("#### Square ####");
        System.out.println(square);
        System.out.println("");

//        System.out.println("#### Square side is:"+ square.getSide() +"####");
        System.out.println("The area of the square: "+square.getArea());
//        System.out.println("The perimeter of the square: "+square.getPerimeter());
//        System.out.println("The color of the square: "+square.getColor());
//        System.out.println("The fill status of the square: "+square.isFilled());
//        System.out.println("========================================\n");

        //Rectangle
        Rectangle rect = new Rectangle("gray",true,129,37);
        System.out.println("#### Rectangle ####");
        System.out.println(rect);
        System.out.println("");


        //Circle
        Circle circle = new Circle("white",false,200);
        System.out.println("#### Circle ####");
        System.out.println(circle);

        System.out.println("\nNOTE: Area/perimeter of square is equal to area of the rectangle.");

    }
}