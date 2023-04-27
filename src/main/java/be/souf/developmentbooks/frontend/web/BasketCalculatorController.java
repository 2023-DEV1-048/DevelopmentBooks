package be.souf.developmentbooks.frontend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.souf.developmentbooks.frontend.BasketCalculatorService;

@RestController
public class BasketCalculatorController {

    @Autowired
    private BasketCalculatorService delegate;

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    public double calculate(@RequestParam(name = "quantity") int... quantity) {
        return delegate.calculate(quantity);
    }

}
