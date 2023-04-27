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
            void same_book(int quantity, double expectedResult) {
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
            void discount_with_2_different_books(int quantityBook1, int quantityBook2, double expectedResult) {
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
                    "2,2,2,270",
                    "3,1,1,235",
                    "3,2,2,320",
                    "3,3,3,405",
                    "4,1,1,285",
                    "4,2,2,370",
                    "4,3,3,455",
                    "4,4,4,540",
                    "5,1,1,335",
                    "5,2,2,420",
                    "5,3,3,505",
                    "5,4,4,590",
                    "5,5,5,675",
                    "6,1,1,385",
                    "6,2,2,470",
                    "6,3,3,555",
                    "6,4,4,640",
                    "6,5,5,725",
                    "6,6,6,810"
            })
            void discount_with_3_different_books(int quantityBook1, int quantityBook2,
                    int quantityBook3,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3)).isEqualTo(expectedResult);
            }
        }

        @Nested
        class DiscountOf20PerCent {
            @ParameterizedTest
            @CsvSource({
                    "1,1,1,1,160",
                    "2,1,1,1,210",
                    "2,2,2,2,320",
                    "3,1,1,1,260",
                    "3,2,2,2,370",
                    "3,3,3,3,480",
                    "4,1,1,1,310",
                    "4,2,2,2,420",
                    "4,3,3,3,530",
                    "4,4,4,4,640",
                    "5,1,1,1,360",
                    "5,2,2,2,470",
                    "5,3,3,3,580",
                    "5,5,5,5,800",
                    "6,1,1,1,410",
                    "6,2,2,2,520",
                    "6,3,3,3,630",
                    "6,4,4,4,740",
                    "6,5,5,5,850",
                    "6,6,6,6,960"
            })
            void discount_with_4_different_books(int quantityBook1, int quantityBook2,
                    int quantityBook3,
                    int quantityBook4,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3, quantityBook4))
                        .isEqualTo(expectedResult);
            }

        }

        @Nested
        class DiscountOf25PerCent {
            @ParameterizedTest
            @CsvSource({
                    "1,1,1,1,1,187.5",
                    "2,1,1,1,1,237.5",
                    "2,2,2,2,2,375.0",
                    "3,1,1,1,1,287.5",
                    "3,2,2,2,2,425.0",
                    "3,3,3,3,3,562.5",
                    "4,1,1,1,1,337.5",
                    "4,2,2,2,2,475.0",
                    "4,3,3,3,3,612.5",
                    "4,4,4,4,4,750.0",
                    "5,1,1,1,1,387.5",
                    "5,2,2,2,2,525.0",
                    "5,3,3,3,3,662.5",
                    "5,4,4,4,4,800.0",
                    "5,5,5,5,5,937.5",
                    "6,1,1,1,1,437.5",
                    "6,2,2,2,2,575.0",
                    "6,3,3,3,3,712.5",
                    "6,4,4,4,4,850.0",
                    "6,5,5,5,5,987.5",
                    "6,6,6,6,6,1125.0",
            })
            void discount_with_5_different_books(int quantityBook1,
                    int quantityBook2,
                    int quantityBook3,
                    int quantityBook4,
                    int quantityBook5,
                    double expectedResult) {
                assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3, quantityBook4, quantityBook5))
                        .isEqualTo(expectedResult);
            }

        }

    }

    @Nested
    class MultipleDiscountToApply {
        @ParameterizedTest
        @CsvSource({
                "2,2,1,230.0",
                "3,2,1,280.0",
                "3,3,1,325.0",
                "4,2,1,330.0",
                "4,3,1,375.0",
                "4,3,2,415.0",
                "4,4,1,420.0",
                "4,4,3,500.0",
                "5,2,1,380.0",
                "5,3,1,425.0",
                "5,3,2,465.0",
                "5,4,1,470.0",
                "5,4,2,510.0",
                "5,4,3,550.0",
                "5,5,1,515.0",
                "5,5,3,595.0",
                "5,5,4,635.0",
                "6,2,1,430.0",
                "6,3,1,475.0",
                "6,3,2,515.0",
                "6,4,1,520.0",
                "6,4,2,560.0",
                "6,4,3,600.0",
                "6,5,1,565.0",
                "6,5,2,605.0",
                "6,5,3,645.0",
                "6,5,4,685.0",
                "6,6,1,610.0",
                "6,6,2,650.0",
                "6,6,3,690.0",
                "6,6,4,730.0",
                "6,6,5,770.0",
        })
        void discount_with_3_different_books(int quantityBook1,
                int quantityBook2,
                int quantityBook3,
                double expectedResult) {
            assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3))
                    .isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({
                "2,2,1,1,255.0",
                "2,2,2,1,295.0",
                "3,2,1,1,305.0",
                "3,2,2,1,345.0",
                "3,3,1,1,350.0",
                "3,3,2,1,390.0",
                "3,3,2,2,415.0",
                "3,3,3,1,430.0",
                "3,3,3,2,455.0",
                "4,2,1,1,355.0",
                "4,2,2,1,395.0",
                "4,3,1,1,400.0",
                "4,3,2,1,440.0",
                "4,3,2,2,465.0",
                "4,3,3,1,480.0",
                "4,3,3,2,505.0",
                "4,4,1,1,445.0",
                "4,4,2,1,485.0",
                "4,4,2,2,510.0",
                "4,4,3,1,525.0",
                "4,4,3,2,550.0",
                "4,4,3,3,575.0",
                "4,4,4,1,565.0",
                "4,4,4,2,590.0",
                "4,4,4,3,615.0",
                "5,2,1,1,405.0",
                "5,2,2,1,445.0",
                "5,3,1,1,450.0",
                "5,3,2,1,490.0",
                "5,3,2,2,515.0",
                "5,3,3,1,530.0",
                "5,3,3,2,555.0",
                "5,4,1,1,495.0",
                "5,4,2,1,535.0",
                "5,4,2,2,560.0",
                "5,4,3,1,575.0",
                "5,4,3,2,600.0",
                "5,4,3,3,625.0",
                "5,4,4,1,615.0",
                "5,4,4,2,640.0",
                "5,4,4,3,665.0",
                "5,4,4,4,690.0",
                "5,5,1,1,540.0",
                "5,5,2,1,580.0",
                "5,5,2,2,605.0",
                "5,5,3,1,620.0",
                "5,5,3,2,645.0",
                "5,5,3,3,670.0",
                "5,5,4,1,660.0",
                "5,5,4,2,685.0",
                "5,5,4,3,710.0",
                "5,5,4,4,735.0",
                "5,5,5,1,700.0",
                "5,5,5,2,725.0",
                "5,5,5,3,750.0",
                "5,5,5,4,775.0",
                "6,2,1,1,455.0",
                "6,2,2,1,495.0",
                "6,3,1,1,500.0",
                "6,3,2,1,540.0",
                "6,3,2,2,565.0",
                "6,3,3,1,580.0",
                "6,3,3,2,605.0",
                "6,4,1,1,545.0",
                "6,4,2,1,585.0",
                "6,4,2,2,610.0",
                "6,4,3,1,625.0",
                "6,4,3,2,650.0",
                "6,4,3,3,675.0",
                "6,4,4,1,665.0",
                "6,4,4,2,690.0",
                "6,4,4,3,715.0",
                "6,5,1,1,590.0",
                "6,5,2,1,630.0",
                "6,5,2,2,655.0",
                "6,5,3,1,670.0",
                "6,5,3,2,695.0",
                "6,5,3,3,720.0",
                "6,5,4,1,710.0",
                "6,5,4,2,735.0",
                "6,5,4,3,760.0",
                "6,5,4,4,785.0",
                "6,5,5,1,750.0",
                "6,5,5,2,775.0",
                "6,5,5,3,800.0",
                "6,5,5,4,825.0",
                "6,6,1,1,635.0",
                "6,6,2,1,675.0",
                "6,6,2,2,700.0",
                "6,6,3,1,715.0",
                "6,6,3,2,740.0",
                "6,6,3,3,765.0",
                "6,6,4,1,755.0",
                "6,6,4,2,780.0",
                "6,6,4,3,805.0",
                "6,6,4,4,830.0",
                "6,6,5,1,795.0",
                "6,6,5,2,820.0",
                "6,6,5,3,845.0",
                "6,6,5,4,870.0",
                "6,6,5,5,895.0",
                "6,6,6,1,835.0",
                "6,6,6,2,860.0",
                "6,6,6,3,885.0",
                "6,6,6,4,910.0",
                "6,6,6,5,935.0",
        })
        void discount_with_4_different_books(int quantityBook1,
                int quantityBook2,
                int quantityBook3,
                int quantityBook4,
                double expectedResult) {
            assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3, quantityBook4))
                    .isEqualTo(expectedResult);
        }

        @ParameterizedTest
        @CsvSource({
                "2,2,1,1,1,282.5",
                "2,2,2,1,1,320.0",
                "2,2,2,2,1,347.5",
                "3,2,1,1,1,332.5",
                "3,2,2,1,1,370.0",
                "3,2,2,2,1,397.5",
                "3,3,1,1,1,377.5",
                "3,3,2,1,1,415.0",
                "3,3,2,2,1,442.5",
                "3,3,2,2,2,470.0",
                "3,3,3,1,1,455.0",
                "3,3,3,2,1,480.0",
                "3,3,3,2,2,510.0",
                "3,3,3,3,1,507.5",
                "3,3,3,3,2,535.0",
                "4,2,1,1,1,382.5",
                "4,2,2,1,1,420.0",
                "4,2,2,2,1,447.5",
                "4,3,1,1,1,427.5",
                "4,3,2,1,1,465.0",
                "4,3,2,2,1,492.5",
                "4,3,2,2,2,520.0",
                "4,3,3,1,1,505.0",
                "4,3,3,2,1,530.0",
                "4,3,3,2,2,560.0",
                "4,3,3,3,1,557.5",
                "4,3,3,3,2,585.0",
                "4,4,1,1,1,472.5",
                "4,4,2,1,1,510.0",
                "4,4,2,2,1,537.5",
                "4,4,2,2,2,565.0",
                "4,4,3,1,1,550.0",
                "4,4,3,2,1,575.0",
                "4,4,3,2,2,605.0",
                "4,4,3,3,1,602.5",
                "4,4,3,3,2,630.0",
                "4,4,3,3,3,657.5",
                "4,4,4,1,1,590.0",
                "4,4,4,2,2,640.0",
                "4,4,4,3,1,640.0",
                "4,4,4,3,2,670.0",
                "4,4,4,3,3,697.5",
                "4,4,4,4,1,667.5",
                "4,4,4,4,2,695.0",
                "4,4,4,4,3,722.5",
                "5,2,1,1,1,432.5",
                "5,2,2,1,1,470.0",
                "5,2,2,2,1,497.5",
                "5,3,1,1,1,477.5",
                "5,3,2,1,1,515.0",
                "5,3,2,2,1,542.5",
                "5,3,2,2,2,570.0",
                "5,3,3,1,1,555.0",
                "5,3,3,2,1,580.0",
                "5,3,3,2,2,610.0",
                "5,3,3,3,1,607.5",
                "5,3,3,3,2,635.0",
                "5,4,1,1,1,522.5",
                "5,4,2,1,1,560.0",
                "5,4,2,2,1,587.5",
                "5,4,2,2,2,615.0",
                "5,4,3,1,1,600.0",
                "5,4,3,2,1,625.0",
                "5,4,3,2,2,655.0",
                "5,4,3,3,1,652.5",
                "5,4,3,3,2,680.0",
                "5,4,3,3,3,707.5",
                "5,4,4,1,1,640.0",
                "5,4,4,2,1,665.0",
                "5,4,4,2,2,690.0",
                "5,4,4,3,1,690.0",
                "5,4,4,3,2,720.0",
                "5,4,4,3,3,747.5",
                "5,4,4,4,1,717.5",
                "5,4,4,4,2,745.0",
                "5,4,4,4,3,772.5",
                "5,5,1,1,1,567.5",
                "5,5,2,1,1,605.0",
                "5,5,2,2,1,632.5",
                "5,5,2,2,2,660.0",
                "5,5,3,1,1,645.0",
                "5,5,3,2,1,670.0",
                "5,5,3,2,2,700.0",
                "5,5,3,3,1,697.5",
                "5,5,3,3,2,725.0",
                "5,5,3,3,3,752.5",
                "5,5,4,1,1,685.0",
                "5,5,4,2,1,710.0",
                "5,5,4,2,2,735.0",
                "5,5,4,3,1,735.0",
                "5,5,4,3,2,765.0",
                "5,5,4,3,3,792.5",
                "5,5,4,4,1,762.5",
                "5,5,4,4,2,790.0",
                "5,5,4,4,3,817.5",
                "5,5,4,4,4,845.0",
                "5,5,5,1,1,725.0",
                "5,5,5,2,1,750.0",
                "5,5,5,2,2,775.0",
                "5,5,5,3,1,775.0",
                "5,5,5,3,2,800.0",
                "5,5,5,3,3,832.5",
                "5,5,5,4,1,800.0",
                "5,5,5,4,2,830.0",
                "5,5,5,4,3,857.5",
                "5,5,5,4,4,885.0",
                "5,5,5,5,1,827.5",
                "5,5,5,5,2,855.0",
                "5,5,5,5,3,882.5",
                "5,5,5,5,4,910.0",
                "6,2,1,1,1,482.5",
                "6,2,2,1,1,520.0",
                "6,2,2,2,1,547.5",
                "6,3,1,1,1,527.5",
                "6,3,2,1,1,565.0",
                "6,3,2,2,1,592.5",
                "6,3,2,2,2,620.0",
                "6,3,3,1,1,605.0",
                "6,3,3,2,1,630.0",
                "6,3,3,2,2,660.0",
                "6,3,3,3,1,657.5",
                "6,3,3,3,2,685.0",
                "6,4,1,1,1,572.5",
                "6,4,2,1,1,610.0",
                "6,4,2,2,1,637.5",
                "6,4,2,2,2,665.0",
                "6,4,3,1,1,650.0",
                "6,4,3,2,1,675.0",
                "6,4,3,2,2,705.0",
                "6,4,3,3,1,702.5",
                "6,4,3,3,2,730.0",
                "6,4,3,3,3,757.5",
                "6,4,4,1,1,690.0",
                "6,4,4,2,1,715.0",
                "6,4,4,2,2,740.0",
                "6,4,4,3,1,740.0",
                "6,4,4,3,2,770.0",
                "6,4,4,3,3,797.5",
                "6,4,4,4,1,767.5",
                "6,4,4,4,2,795.0",
                "6,4,4,4,3,822.5",
                "6,5,1,1,1,617.5",
                "6,5,2,1,1,655.0",
                "6,5,2,2,1,682.5",
                "6,5,2,2,2,710.0",
                "6,5,3,1,1,695.0",
                "6,5,3,2,1,720.0",
                "6,5,3,2,2,750.0",
                "6,5,3,3,1,747.5",
                "6,5,3,3,2,775.0",
                "6,5,3,3,3,802.5",
                "6,5,4,1,1,735.0",
                "6,5,4,2,1,760.0",
                "6,5,4,2,2,785.0",
                "6,5,4,3,1,785.0",
                "6,5,4,3,2,815.0",
                "6,5,4,3,3,842.5",
                "6,5,4,4,1,812.5",
                "6,5,4,4,2,840.0",
                "6,5,4,4,3,867.5",
                "6,5,4,4,4,895.0",
                "6,5,5,1,1,775.0",
                "6,5,5,2,1,800.0",
                "6,5,5,2,2,825.0",
                "6,5,5,3,1,825.0",
                "6,5,5,3,2,850.0",
                "6,5,5,3,3,882.5",
                "6,5,5,4,1,850.0",
                "6,5,5,4,2,880.0",
                "6,5,5,4,3,907.5",
                "6,5,5,4,4,935.0",
                "6,5,5,5,1,877.5",
                "6,5,5,5,2,905.0",
                "6,5,5,5,3,932.5",
                "6,5,5,5,4,960.0",
                "6,6,1,1,1,662.5",
                "6,6,2,1,1,700.0",
                "6,6,2,2,1,727.5",
                "6,6,2,2,2,755.0",
                "6,6,3,1,1,740.0",
                "6,6,3,2,1,765.0",
                "6,6,3,2,2,795.0",
                "6,6,3,3,1,792.5",
                "6,6,3,3,2,820.0",
                "6,6,3,3,3,847.5",
                "6,6,4,1,1,780.0",
                "6,6,4,2,1,805.0",
                "6,6,4,2,2,830.0",
                "6,6,4,3,1,830.0",
                "6,6,4,3,2,860.0",
                "6,6,4,3,3,887.5",
                "6,6,4,4,1,857.5",
                "6,6,4,4,2,885.0",
                "6,6,4,4,3,912.5",
                "6,6,4,4,4,940.0",
                "6,6,5,1,1,820.0",
                "6,6,5,2,1,845.0",
                "6,6,5,2,2,870.0",
                "6,6,5,3,1,870.0",
                "6,6,5,3,2,895.0",
                "6,6,5,3,3,927.5",
                "6,6,5,4,1,895.0",
                "6,6,5,4,2,925.0",
                "6,6,5,4,3,952.5",
                "6,6,5,4,4,980.0",
                "6,6,5,5,1,922.5",
                "6,6,5,5,2,950.0",
                "6,6,5,5,3,977.5",
                "6,6,5,5,4,1005.0",
                "6,6,5,5,5,1032.5",
                "6,6,6,1,1,860.0",
                "6,6,6,2,1,885.0",
                "6,6,6,2,2,910.0",
                "6,6,6,3,1,910.0",
                "6,6,6,3,2,935.0",
                "6,6,6,3,3,960.0",
                "6,6,6,4,1,935.0",
                "6,6,6,4,2,960.0",
                "6,6,6,4,3,992.5",
                "6,6,6,4,4,1020.0",
                "6,6,6,5,1,960.0",
                "6,6,6,5,2,990.0",
                "6,6,6,5,3,1017.5",
                "6,6,6,5,4,1045.0",
                "6,6,6,5,5,1072.5",
                "6,6,6,6,1,987.5",
                "6,6,6,6,2,1015.0",
                "6,6,6,6,3,1042.5",
                "6,6,6,6,4,1070.0",
                "6,6,6,6,5,1097.5",
        })
        void discount_with_5_different_books(int quantityBook1,
                int quantityBook2,
                int quantityBook3,
                int quantityBook4,
                int quantityBook5,
                double expectedResult) {
            assertThat(tested.calculate(quantityBook1, quantityBook2, quantityBook3, quantityBook4, quantityBook5))
                    .isEqualTo(expectedResult);
        }
    }
}
