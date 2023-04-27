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
                assertThat(tested.calculate(quantity)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantity)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantity)).isEqualTo(expectedResult);

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
                    "6,6,570"
            })
            void n_book_of_book1_and_m_book_of_book2(int quantityBook1, int quantityBook2, double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1)).isEqualTo(expectedResult);

            }
        }

        @Nested
        class DiscountOf10PerCent {
            @ParameterizedTest
            @CsvSource({
                    "1,1,1,135",
                    "2,1,1,185",
                    "2,2,1,235",
                    "2,2,2,270",
                    "3,1,1,235",
                    "3,2,1,285",
                    "3,2,2,320",
                    "3,3,1,335",
                    "3,3,2,370",
                    "3,3,3,405",
                    "4,1,1,285",
                    "4,2,1,335",
                    "4,2,2,370",
                    "4,3,1,385",
                    "4,3,2,420",
                    "4,3,3,455",
                    "4,4,1,435",
                    "4,4,2,470",
                    "4,4,3,505",
                    "4,4,4,540",
                    "5,1,1,335",
                    "5,2,1,385",
                    "5,2,2,420",
                    "5,3,1,435",
                    "5,3,2,470",
                    "5,3,3,505",
                    "5,4,1,485",
                    "5,4,2,520",
                    "5,4,3,555",
                    "5,4,4,590",
                    "5,5,1,535",
                    "5,5,2,570",
                    "5,5,3,605",
                    "5,5,4,640",
                    "5,5,5,675",
                    "6,1,1,385",
                    "6,2,1,435",
                    "6,2,2,470",
                    "6,3,1,485",
                    "6,3,2,520",
                    "6,3,3,555",
                    "6,4,1,535",
                    "6,4,2,570",
                    "6,4,3,605",
                    "6,4,4,640",
                    "6,5,1,585",
                    "6,5,2,620",
                    "6,5,3,655",
                    "6,5,4,690",
                    "6,5,5,725",
                    "6,6,1,635",
                    "6,6,2,670",
                    "6,6,3,705",
                    "6,6,4,740",
                    "6,6,5,775",
                    "6,6,6,810"
            })
            void n_book_of_book1_and_m_book_of_book2(int quantityBook1, int quantityBook2, int quantityBook3,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1, quantityBook3)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook3, quantityBook1)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook1, quantityBook3, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook3, quantityBook1, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook3, quantityBook2, quantityBook1)).isEqualTo(expectedResult);
            }
        }

    }

}
