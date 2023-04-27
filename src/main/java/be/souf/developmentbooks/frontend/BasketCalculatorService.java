package be.souf.developmentbooks.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.souf.developmentbooks.task.BasketCalculator;

@Component
public class BasketCalculatorService {

    @Autowired
    private BasketCalculator task;

    public double calculate(int... quantityEachBook) {
        return task.calculate(quantityEachBook);
    }

}
