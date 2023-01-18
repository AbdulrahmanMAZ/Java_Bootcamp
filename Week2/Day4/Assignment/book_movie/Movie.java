package Assignment.book_movie;

public class Movie extends Product{
    private String director;

    public Movie() {
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    @Override
    public double getDiscount() {
        int discount = 15;

        return ((super.getPrice() / 100) * discount);
    }

}
