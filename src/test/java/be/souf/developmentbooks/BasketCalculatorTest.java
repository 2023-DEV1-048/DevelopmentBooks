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
        class DiscountOf10PerCent {

            @ParameterizedTest
            @CsvSource({
                    "1,1,90",
                    "2,1,140",
                    "2,2,180",
                    "3,1,190",
                    "3,2,230",
                    "3,3,270",
                    "4,1,240",
                    "4,2,280",
                    "4,3,320",
                    "4,4,360",
                    "5,1,290",
                    "5,2,330",
                    "5,3,370",
                    "5,4,410",
                    "5,5,450",
                    "6,1,340",
                    "6,2,380",
                    "6,3,420",
                    "6,4,460",
                    "6,5,500",
                    "6,6,540",
            })
            void n_book_of_book1_and_m_book_of_book2(int quantityBook1, int quantityBook2, double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1)).isEqualTo(expectedResult);
            }

        }
    }

}
