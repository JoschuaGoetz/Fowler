import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

class Customer
{
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String newName)
    {
        name = newName;
    }

    public void addRental(Rental arg)
    {
        rentals.add(arg);
    }

    public String getName()
    {
        return name;
    }

    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "main.java.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for(Rental rental: rentals) {
            frequentRenterPoints += calcFrequentRenterPoints(rental);
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getAmount() + "\n";
            totalAmount += rental.getAmount();
        }
                    
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private int calcFrequentRenterPoints(Rental rental) {
        //Always add one point. If a new release was rented for more than 1 day return 2 points
        return ((rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && rental.getDaysRented() > 1) ? 2 : 1;
    }


}
    