package Assignment.book_movie;

public class Book extends Product{

    private String author;

    public Book() {
    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double getDiscount() {
        int discount = 10;

        return ((super.getPrice() / 100) * discount);
    }
}
