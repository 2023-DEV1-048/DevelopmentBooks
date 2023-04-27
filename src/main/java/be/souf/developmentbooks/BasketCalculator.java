package be.souf.developmentbooks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasketCalculator {

    public static final double UNIT_PRICE = 50.0;

    private static final double[] DISCOUNTS = new double[] { 0, 1, 0.95, 0.90, 0.80, 0.75 };

    public double calculate(int... quantitiesByBook) {

        // init without discount
        double bestPrice = calculate(Arrays.stream(quantitiesByBook).sum());

        for (int i = DISCOUNTS.length - 1; i > 1; i--) {
            bestPrice = Math.min(bestPrice, calculate(i, Arrays.stream(quantitiesByBook).toArray()));
        }

        return bestPrice;
    }

    private double calculate(int sizeMin, int... quantitiesByBook) {
        if (sizeMin == 0) {
            return 0;
        }

        int nbDiscount = min(sizeMin, quantitiesByBook);
        double resultWithDiscount = 0;
        if (nbDiscount > 0) {
            resultWithDiscount = calculate(nbDiscount) * sizeMin * DISCOUNTS[sizeMin];
            removeOneBookForEach(sizeMin, nbDiscount, quantitiesByBook);
            return resultWithDiscount + calculate(sizeMin, quantitiesByBook);
        }

        return resultWithDiscount + calculate(sizeMin - 1, quantitiesByBook);
    }

    private void removeOneBookForEach(int nbToRemove, int minus, int... quantitiesByBook) {
        for (int i = 0; i < quantitiesByBook.length && nbToRemove > 0; i++) {
            int result = quantitiesByBook[i] - minus;
            if (result >= 0) {
                nbToRemove--;
                quantitiesByBook[i] = result;
            }
        }
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
