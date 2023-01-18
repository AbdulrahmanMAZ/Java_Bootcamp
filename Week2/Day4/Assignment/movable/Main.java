package Assignment.movable;

import Assignment.book_movie.Book;

public class Main {
    public static void main(String[] args) {
        Movable point = new MovablePoint(0,0,30,30);
        point.moveUp();
        point.moveRight();
        point.moveLeft();
        point.moveDown();


    }
}
