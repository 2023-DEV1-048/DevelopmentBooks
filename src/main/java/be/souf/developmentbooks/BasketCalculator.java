package be.souf.developmentbooks;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasketCalculator {

    public static final double UNIT_PRICE = 50.0;

    public double calculate(int... quantitiesByBook) {

        double result = 0;
        int nbDiscount = 0;

        if (quantitiesByBook.length >= 5) {
            nbDiscount = min(5, quantitiesByBook);
            result += calculate(nbDiscount) * 5 * 0.75;
        }
        if (nbDiscount == 0 && quantitiesByBook.length >= 4) {
            nbDiscount = min(4, quantitiesByBook);
            result += calculate(nbDiscount) * 4 * 0.80;
        }
        if (nbDiscount == 0 && quantitiesByBook.length >= 3) {
            nbDiscount = min(3, quantitiesByBook);
            result += calculate(nbDiscount) * 3 * 0.90;
        }
        if (nbDiscount == 0 && quantitiesByBook.length >= 2) {
            nbDiscount = min(2, quantitiesByBook);
            result += calculate(nbDiscount) * 2 * 0.95;
        }

        for (int i = 0; i < quantitiesByBook.length; i++) {
            if (quantitiesByBook[i] > nbDiscount) {
                result += calculate(quantitiesByBook[i] - nbDiscount);

            }
        }

        return result;
    }

    private double calculate(int quantityBook) {
        return quantityBook * UNIT_PRICE;
    }

    private int min(int minSizeWithout0, int... values) {

        List<Integer> valuesInSet =
                IntStream
                        .of(values)
                        .filter(i -> i > 0)
                        .mapToObj(Integer::valueOf)
                        .collect(Collectors.toList());

        if (valuesInSet.size() >= minSizeWithout0) {
            return valuesInSet.stream().min(Integer::compare).get();
        }
        return 0;
    }

}
