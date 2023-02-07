package ee.eek;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableListAssert.assertThat;

public class AppTest {
    @Test
    void helloTest() {
        Assertions.assertThat(2 + 2).isEqualTo(4);
    }


    @Test
    void testArrayReverse() {
        //ARRANGE
        int[] input = new int[]{1, 2, 3, 4, 5};
        //ACT
        Homework.reverseIntArray(input);
        //ASSERT
        Assertions.assertThat(input)
                .isEqualTo(new int[]{5, 4, 3, 2, 1});
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 8",
            "3, 4, 81",
            "-1, 2, 1",
            "43, 0, 1"})
    void powerFunction(double x, int n, double result) {
        Assertions
                .assertThat(Homework.power(x, n))
                .isEqualTo(result);
    }
}
