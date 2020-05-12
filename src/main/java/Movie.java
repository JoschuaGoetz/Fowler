public class Movie
{
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;

    public Movie(String newTitle, int newPriceTag)
    {
        title = newTitle;
        priceCode = newPriceTag;
    }

    public int getPriceCode()
    {
        return priceCode;
    }

    public void setPriceCode(int arg)
    {
        priceCode = arg;
    }

    public String getTitle()
    {
        return title;
    }
}