package Assignment.book_movie;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The book",12,"Me");
        Movie movie = new Movie("AVATAR",12,"james cameron");
        System.out.println(book.getDiscount());
        System.out.println(movie.getDiscount());

    }
}
