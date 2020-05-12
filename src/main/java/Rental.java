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
        double thisAmount = 0;
        switch (movie.getPriceCode())
        {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
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