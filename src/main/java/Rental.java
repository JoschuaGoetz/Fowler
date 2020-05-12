class Rental
{
    private final Movie movie;
    private final int daysRented;
    private final double amount;

    public Rental(Movie newMovie, int newDaysRented)
    {
        movie = newMovie;
        daysRented = newDaysRented;
        amount = calcAmount();
    }

    private double calcAmount()
    {
        return this.movie.getPriceCode().getPrice(daysRented);
    }

    public int getDaysRented()
    {
        return daysRented;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public double getAmount()
    {
        return amount;
    }
}