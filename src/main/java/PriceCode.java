public enum PriceCode
{
    REGULAR {
        @Override
        public double getPrice(int rentalDuration)
        {
            double thisAmount = 2;
            if (rentalDuration > 2)
                thisAmount += (rentalDuration - 2) * 1.5;
            return thisAmount;
        }
    },
    NEW_RELEASE {
        @Override
        public double getPrice(int rentalDuration)
        {
            return rentalDuration * 3;
        }
    },
    CHILDREN {
        @Override
        public double getPrice(int rentalDuration)
        {
            double thisAmount = 1.5;
            if (rentalDuration > 3)
                thisAmount += (rentalDuration - 3) * 1.5;
            return thisAmount;
        }
    };

    public abstract double getPrice(int rentalDuration);
}