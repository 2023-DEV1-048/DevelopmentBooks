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
            void n_book_of_book1_and_m_book_of_book2_and_o_book3(int quantityBook1, int quantityBook2,
                    int quantityBook3,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1, quantityBook3)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook3, quantityBook1)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook1, quantityBook3, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook3, quantityBook1, quantityBook2)).isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook3, quantityBook2, quantityBook1)).isEqualTo(expectedResult);
            }
        }

        @Nested
        class DiscountOf20PerCent {
            @ParameterizedTest
            @CsvSource({
                    "1,1,1,1,160",
                    "2,1,1,1,210",
                    "2,2,1,1,260",
                    "2,2,2,1,310",
                    "2,2,2,2,320",
                    "3,1,1,1,260",
                    "3,2,1,1,310",
                    "3,2,2,1,360",
                    "3,2,2,2,370",
                    "3,3,1,1,360",
                    "3,3,2,1,410",
                    "3,3,2,2,420",
                    "3,3,3,1,460",
                    "3,3,3,2,470",
                    "3,3,3,3,480",
                    "4,1,1,1,310",
                    "4,2,1,1,360",
                    "4,2,2,1,410",
                    "4,2,2,2,420",
                    "4,3,1,1,410",
                    "4,3,2,1,460",
                    "4,3,2,2,470",
                    "4,3,3,1,510",
                    "4,3,3,2,520",
                    "4,3,3,3,530",
                    "4,4,1,1,460",
                    "4,4,2,1,510",
                    "4,4,2,2,520",
                    "4,4,3,1,560",
                    "4,4,3,2,570",
                    "4,4,3,3,580",
                    "4,4,4,1,610",
                    "4,4,4,2,620",
                    "4,4,4,3,630",
                    "4,4,4,4,640",
                    "5,1,1,1,360",
                    "5,2,1,1,410",
                    "5,2,2,1,460",
                    "5,2,2,2,470",
                    "5,3,1,1,460",
                    "5,3,2,1,510",
                    "5,3,2,2,520",
                    "5,3,3,1,560",
                    "5,3,3,2,570",
                    "5,3,3,3,580",
                    "5,4,1,1,510",
                    "5,4,2,1,560",
                    "5,4,2,2,570",
                    "5,4,3,1,610",
                    "5,4,3,2,620",
                    "5,4,3,3,630",
                    "5,4,4,1,660",
                    "5,4,4,2,670",
                    "5,4,4,3,680",
                    "5,4,4,4,690",
                    "5,5,1,1,560",
                    "5,5,2,1,610",
                    "5,5,2,2,620",
                    "5,5,3,1,660",
                    "5,5,3,2,670",
                    "5,5,3,3,680",
                    "5,5,4,1,710",
                    "5,5,4,2,720",
                    "5,5,4,3,730",
                    "5,5,4,4,740",
                    "5,5,5,1,760",
                    "5,5,5,2,770",
                    "5,5,5,3,780",
                    "5,5,5,4,790",
                    "5,5,5,5,800",
                    "6,1,1,1,410",
                    "6,2,1,1,460",
                    "6,2,2,1,510",
                    "6,2,2,2,520",
                    "6,3,1,1,510",
                    "6,3,2,1,560",
                    "6,3,2,2,570",
                    "6,3,3,1,610",
                    "6,3,3,2,620",
                    "6,3,3,3,630",
                    "6,4,1,1,560",
                    "6,4,2,1,610",
                    "6,4,2,2,620",
                    "6,4,3,1,660",
                    "6,4,3,2,670",
                    "6,4,3,3,680",
                    "6,4,4,1,710",
                    "6,4,4,2,720",
                    "6,4,4,3,730",
                    "6,4,4,4,740",
                    "6,5,1,1,610",
                    "6,5,2,1,660",
                    "6,5,2,2,670",
                    "6,5,3,1,710",
                    "6,5,3,2,720",
                    "6,5,3,3,730",
                    "6,5,4,1,760",
                    "6,5,4,2,770",
                    "6,5,4,3,780",
                    "6,5,4,4,790",
                    "6,5,5,1,810",
                    "6,5,5,2,820",
                    "6,5,5,3,830",
                    "6,5,5,4,840",
                    "6,5,5,5,850",
                    "6,6,1,1,660",
                    "6,6,2,1,710",
                    "6,6,2,2,720",
                    "6,6,3,1,760",
                    "6,6,3,2,770",
                    "6,6,3,3,780",
                    "6,6,4,1,810",
                    "6,6,4,2,820",
                    "6,6,4,3,830",
                    "6,6,4,4,840",
                    "6,6,5,1,860",
                    "6,6,5,2,870",
                    "6,6,5,3,880",
                    "6,6,5,4,890",
                    "6,6,5,5,900",
                    "6,6,6,1,910",
                    "6,6,6,2,920",
                    "6,6,6,3,930",
                    "6,6,6,4,940",
                    "6,6,6,5,950",
                    "6,6,6,6,960"
            })
            void n_book_of_book1_and_m_book_of_book2_and_o_book3_and_p_book4(int quantityBook1, int quantityBook2,
                    int quantityBook3,
                    int quantityBook4,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3, quantityBook4))
                        .isEqualTo(expectedResult);
                assertThat(tested.calculate(quantityBook2, quantityBook1, quantityBook3, quantityBook4))
                        .isEqualTo(expectedResult);
            }

        }
    }

}
