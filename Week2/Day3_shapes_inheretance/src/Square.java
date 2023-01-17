public class Square extends Rectangle{
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled,double side) {
        super(color, filled, side,side);
    }
    public double getSide(){
        return super.getWidth();
    }
    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);

    }
//    public double getArea(double side){
//        return super.getLength() * 4;
//
//    }

    @Override
    public String toString() {
//        return "Square{side='"+super.getWidth()+"', which is subclass of:{"+super.toString()+"} }";
        return  "A Square with side="+ getSide()+", which is a subclass of "+super.toString();
    }
}
