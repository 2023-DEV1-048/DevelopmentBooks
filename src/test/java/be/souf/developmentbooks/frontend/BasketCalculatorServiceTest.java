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
        randomPrice = random();
        when(task.calculate(any())).thenReturn(randomPrice);
    }

    @Test
    void calculate_with_1_distinct_book() {
        assertThat(tested.calculate((int) random())).isEqualTo(randomPrice);
    }

    @Test
    void calculate_with_2_distinct_book() {

    }

    @Test
    void calculate_with_3_distinct_book() {

    }

    @Test
    void calculate_with_4_distinct_book() {

    }

    @Test
    void calculate_with_5_distinct_book() {

    }

    private double random() {
        return Math.random() * 1000;
    }

}
