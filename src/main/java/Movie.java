public class Movie
{
    private final String title;
    private PriceCode priceCode;

    public Movie(String newTitle, PriceCode newPriceTag)
    {
        title = newTitle;
        priceCode = newPriceTag;
    }

    public PriceCode getPriceCode()
    {
        return priceCode;
    }

    public void setPriceCode(PriceCode arg)
    {
        priceCode = arg;
    }

    public String getTitle()
    {
        return title;
    }

}

