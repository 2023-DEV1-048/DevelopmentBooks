package be.souf.developmentbooks;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasketCalculatorTest {

    private final BasketCalculator tested = new BasketCalculator();

    @Nested
    class NoDiscount {
        @Nested
        class SameCopyOfBook {

            @ParameterizedTest
            @CsvSource({
                    "0,0",
                    "1,50",
                    "2,100",
                    "3,150",
                    "4,200",
                    "5,250",
                    "6,300"
            })
            void n_book(int quantity, double expectedResult) {
                assertThat(tested.calculate(quantity, 0)).isEqualTo(expectedResult);
                assertThat(tested.calculate(0, quantity)).isEqualTo(expectedResult);
            }

        }
    }

    @Nested
    class OnlyOneDiscountCanBeDone {
        @Nested
        class DiscountOf5PerCent {
            @ParameterizedTest
            @CsvSource({
                    "1,1,95",
                    "2,1,145",
                    "2,2,190",
                    "3,1,195",
                    "3,2,240",
                    "3,3,285",
                    "4,1,245",
                    "4,2,290",
                    "4,3,335",
                    "4,4,380",
                    "5,1,295",
                    "5,2,340",
                    "5,3,385",
                    "5,4,430",
                    "5,5,475",
                    "6,1,345",
                    "6,2,390",
                    "6,3,435",
                    "6,4,480",
                    "6,5,525",
                    "6,6,570",
            })
            void n_book_of_book1_and_m_book_of_book2(int quantityBook1, int quantityBook2, double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1)).isEqualTo(expectedResult);
            }
        }

    }

}
