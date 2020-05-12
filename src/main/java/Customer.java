import java.util.Enumeration;
import java.util.Vector;

class Customer
{
    private String name;
    private Vector rentals = new Vector();

    public Customer(String newName)
    {
        name = newName;
    }

    public void addRental(Rental arg)
    {
        rentals.addElement(arg);
    }

    public String getName()
    {
        return name;
    }

    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String result = "main.java.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements())
        {
            Rental each = (Rental) enum_rentals.nextElement();

            frequentRenterPoints += calcFrequentRenterPoints(each);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + each.getAmount() + "\n";
            totalAmount += each.getAmount();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private int calcFrequentRenterPoints(Rental rental) {
        //Always add one point. If a new release was rented for more than 1 day return 2 points
        return ((rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && rental.getDaysRented() > 1) ? 2 : 1;
    }


}
    