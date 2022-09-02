import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MainTest {

    @BeforeAll
    public static void initSuite() {
        System.out.println("Запуск всех тестов");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Завершение тестирования кода");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Запуск теста");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Завершение теста");
    }

    @Test
    public void testTaxEarnindsMinusSpendings() {
        //arrange
        int a = 100, b = 70, expected = 4;
        int noExpected = 100;
        //act
        int result = Main.taxEarnindsMinusSpendings(a, b);
        //assert
        assertEquals(expected, result);
        assertNotEquals(noExpected, result);
    }

    @Test
    public void testTaxEarninds() {
        //arrange
        int a = 100, expected = 6;
        //act
        int result = Main.taxEarninds(a);
        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testName() {
        //arrange
        String argument = "ООО ЛУНА";
        String expected = "Наименование компании для которой подбирается налоговая система: \nООО ЛУНА";
        //act
        String result = Main.name(argument);
        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testTaxEarninds(int a, int expected) {
        int result = Main.taxEarninds(a);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(100, 6),
                Arguments.of(850, 51)
        );
    }
}
