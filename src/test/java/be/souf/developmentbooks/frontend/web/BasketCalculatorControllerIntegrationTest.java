package be.souf.developmentbooks.frontend.web;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BasketCalculatorControllerIntegrationTest {

    @Autowired
    private BasketCalculatorController tested;

    @Test
    void calculate_with_1_distinct_book() {
        assertThat(tested.calculate(1)).isEqualTo(50);
    }

    @Test
    void calculate_with_2_distinct_book() {
        assertThat(tested.calculate(3, 1)).isEqualTo(195);

    }

    @Test
    void calculate_with_3_distinct_book() {
        assertThat(tested.calculate(1, 2, 3)).isEqualTo(280);

    }

    @Test
    void calculate_with_4_distinct_book() {
        assertThat(tested.calculate(2, 2, 4, 1)).isEqualTo(395);

    }

    @Test
    void calculate_with_5_distinct_book() {
        assertThat(tested.calculate(2, 2, 2, 1, 1)).isEqualTo(320);

    }

}
