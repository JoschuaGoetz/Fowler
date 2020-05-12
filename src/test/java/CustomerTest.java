import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest
{
    private static Customer customer;

    @BeforeAll
    static void setup()
    {
        customer = new Customer("Steve");
    }

    @Test
    void statementTest()
    {
        Movie movie = new Movie("movie1", 1);
        Rental rental = new Rental(movie, 10);
        customer.addRental(rental);

        assertEquals("main.java.Rental Record for Steve\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "Amount owed is 30.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }
}
