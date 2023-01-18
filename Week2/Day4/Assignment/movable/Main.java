package Assignment.movable;

import Assignment.book_movie.Book;

public class Main {
    public static void main(String[] args) {
        Movable point = new MovablePoint(0,0,30,10);
        point.moveUp();
        point.moveUp();
        point.moveRight();
        point.moveRight();
        System.out.println(point);


    }
}
