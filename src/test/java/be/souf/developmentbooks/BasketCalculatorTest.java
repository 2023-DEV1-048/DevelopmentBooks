package be.souf.developmentbooks;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BasketCalculatorTest {

    private final BasketCalculator tested = new BasketCalculator();

    @Nested
    class SameCopyOfBook {
        @Test
        void one_copy() {
            assertThat(tested.calculate(1)).isEqualTo(50);
        }

        @Test
        void two_copies() {
            assertThat(tested.calculate(2)).isEqualTo(100);
        }

        @Test
        void three_copies() {
            assertThat(tested.calculate(3)).isEqualTo(150);
        }

        @Test
        void four_copies() {
            assertThat(tested.calculate(4)).isEqualTo(200);
        }

        @Test
        void five_copies() {
            assertThat(tested.calculate(5)).isEqualTo(250);
        }

        @Test
        void six_copies() {
            assertThat(tested.calculate(6)).isEqualTo(300);
        }
    }

}
