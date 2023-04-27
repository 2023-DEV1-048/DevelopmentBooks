package be.souf.developmentbooks.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class BasketCalculator {

    public static final double UNIT_PRICE = 50.0;

    private static final double[] DISCOUNTS = new double[] { 0, 1, 0.95, 0.90, 0.80, 0.75 };

    /**
     * Calculate the best price with discount.
     *
     * @param quantitiesByBook the quantities for each book
     * @return the best price
     */
    public double calculate(int... quantitiesByBook) {

        // price without discount
        double bestPrice = calculate(Arrays.stream(quantitiesByBook).sum());

        for (int i = DISCOUNTS.length - 1; i > 1; i--) {
            bestPrice = Math.min(bestPrice, calculate(i, Arrays.stream(quantitiesByBook).toArray()));
        }

        return bestPrice;
    }

    private double calculate(int minimalDifferentBooks, int... quantitiesByBook) {
        if (minimalDifferentBooks == 0) {
            return 0;
        }

        int nbDiscount = getNbDiscount(minimalDifferentBooks, quantitiesByBook);
        if (nbDiscount > 0) {
            removeQuantityForEachBook(minimalDifferentBooks, nbDiscount, quantitiesByBook);
            return calculate(nbDiscount) * minimalDifferentBooks * DISCOUNTS[minimalDifferentBooks]
                    + calculate(minimalDifferentBooks, quantitiesByBook);
        }

        return calculate(minimalDifferentBooks - 1, quantitiesByBook);
    }

    private double calculate(int quantityBook) {
        return quantityBook * UNIT_PRICE;
    }

    private void removeQuantityForEachBook(int nbToRemove, int minus, int... quantitiesByBook) {
        for (int i = 0; i < quantitiesByBook.length && nbToRemove > 0; i++) {
            int result = quantitiesByBook[i] - minus;
            if (result >= 0) {
                nbToRemove--;
                quantitiesByBook[i] = result;
            }
        }
    }

    private int getNbDiscount(int minimalDifferentBooks, int... values) {

        List<Integer> valuesInSet =
                IntStream
                        .of(values)
                        .filter(i -> i > 0)
                        .mapToObj(Integer::valueOf)
                        .collect(Collectors.toList());

        if (valuesInSet.size() >= minimalDifferentBooks) {
            return valuesInSet.stream().min(Integer::compare).orElse(0);
        }
        return 0;
    }

}
