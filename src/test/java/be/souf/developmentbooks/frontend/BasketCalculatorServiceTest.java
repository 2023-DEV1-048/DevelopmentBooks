package be.souf.developmentbooks.frontend;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import be.souf.developmentbooks.task.BasketCalculator;

@ExtendWith(MockitoExtension.class)
public class BasketCalculatorServiceTest {

    @Mock
    private BasketCalculator task;

    @InjectMocks
    private BasketCalculatorService tested;

    private double randomPrice;

    @BeforeEach
    void init() {
        randomPrice = randomPrice();
        when(task.calculate(any())).thenReturn(randomPrice);
    }

    @Test
    void calculate_with_1_distinct_book() {
        assertThat(tested.calculate(randomQuantity())).isEqualTo(randomPrice);
    }

    @Test
    void calculate_with_2_distinct_book() {
        assertThat(tested.calculate(randomQuantity(), randomQuantity())).isEqualTo(randomPrice);

    }

    @Test
    void calculate_with_3_distinct_book() {
        assertThat(tested.calculate(randomQuantity(), randomQuantity(), randomQuantity())).isEqualTo(randomPrice);

    }

    @Test
    void calculate_with_4_distinct_book() {
        assertThat(tested.calculate(randomQuantity(), randomQuantity(), randomQuantity(), randomQuantity()))
                .isEqualTo(randomPrice);

    }

    @Test
    void calculate_with_5_distinct_book() {
        assertThat(tested.calculate(randomQuantity(), randomQuantity(), randomQuantity(), randomQuantity()))
                .isEqualTo(randomPrice);

    }

    private int randomQuantity() {
        return (int) (Math.random() * 1000);
    }

    private double randomPrice() {
        return Math.random() * 1000;
    }

}
