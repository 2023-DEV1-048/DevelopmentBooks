package be.souf.developmentbooks;

public class BasketCalculator {

    public static final double UNIT_PRICE = 50.0;

    public double calculate(int quantityBook1, int quantityBook2) {
        int nbPossibleDiscount = Math.min(quantityBook1, quantityBook2);

        return calculate(quantityBook2 - nbPossibleDiscount) + calculate(quantityBook1 - nbPossibleDiscount)
                + ((calculate(nbPossibleDiscount) + calculate(nbPossibleDiscount)) * 0.9);
    }

    private double calculate(int quantityBook) {
        return quantityBook * UNIT_PRICE;
    }

}
