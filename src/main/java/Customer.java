import java.util.ArrayList;
import java.util.List;

class Customer
{
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();
    private int frequentRenterPoints;
    private double amount;

    public Customer(String newName)
    {
        this.name = newName;
        this.frequentRenterPoints = 0;
        this.amount = 0;
    }

    public void addRental(Rental rental)
    {
        rentals.add(rental);
        this.addRenterPoints(rental);
        this.addAmount(rental);
    }

    private void addAmount(Rental rental)
    {
        this.amount += rental.getAmount();
    }

    private void addRenterPoints(Rental rental)
    {
        this.frequentRenterPoints += calcFrequentRenterPoints(rental);
    }

    public String getName()
    {
        return name;
    }

    public String statement()
    {
        StringBuilder result = new StringBuilder("main.java.Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental : rentals)
        {
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append("\t")
                    .append(rental.getDaysRented())
                    .append("\t").append(rental.getAmount())
                    .append("\n");
        }

        //add footer lines
        result.append("Amount owed is ")
                .append(this.amount)
                .append("\n");
        result.append("You earned ")
                .append(this.frequentRenterPoints)
                .append(" frequent renter points");
        return result.toString();
    }

    private int calcFrequentRenterPoints(Rental rental)
    {
        //Always add one point. If a new release was rented for more than 1 day return 2 points
        return ((rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && rental.getDaysRented() > 1) ? 2 : 1;
    }


}
    