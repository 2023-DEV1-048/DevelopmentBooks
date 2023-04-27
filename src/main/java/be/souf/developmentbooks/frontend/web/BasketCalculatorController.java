package be.souf.developmentbooks.frontend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import be.souf.developmentbooks.frontend.BasketCalculatorService;

@Controller
public class BasketCalculatorController {

    @Autowired
    private BasketCalculatorService delegate;

    @GetMapping("/calculate")
    public double calculate(int... i) {
        return delegate.calculate(i);
    }

}
