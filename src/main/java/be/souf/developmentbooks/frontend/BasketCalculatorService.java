package be.souf.developmentbooks.frontend;

import be.souf.developmentbooks.task.BasketCalculator;

public class BasketCalculatorService {

    private BasketCalculator task;

    public double calculate(int... quantityEachBook) {
        return task.calculate(quantityEachBook);
    }

}
