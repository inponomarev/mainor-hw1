package ee.eek;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class HomeworkTest {

    //Task 1
    @ParameterizedTest(name = "array of length {0}")
    @ValueSource(ints = {0, 1, 2, 3, 5, 8})
    void arrayReverse(int n) {
        //ARRANGE
        int[] input = new int[n];
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
            output[n - i - 1] = i + 1;
        }
        //ACT
        Homework.reverseIntArray(input);
        //ASSERT
        Assertions.assertThat(input).isEqualTo(output);
    }

    //Task 2
    @ParameterizedTest
    @CsvSource({
            "mainor, 0",
            "oop, 2",
            "javajava, -1",
            "abcabe, 2"})
    void firstNonRepeating(String input, int output) {
        Assertions.assertThat(Homework.firstNonRepeating(input)).isEqualTo(output);
    }

    //Task 3
    @ParameterizedTest
    @CsvSource({
            "2, 3, 8",
            "3, 4, 81",
            "-1, 2, 1",
            "43, 0, 1",
            "17, 1, 17"})
    void powerFunction(double x, int n, double result) {
        Assertions
                .assertThat(Homework.power(x, n))
                .isEqualTo(result);
    }

    //Task 4
    @ParameterizedTest
    @MethodSource
    void maxValue(int[] input, int maxValue) {
        Assertions.assertThat(Homework.maxValue(input))
                .isEqualTo(maxValue);
    }

    public static Stream<Arguments> maxValue() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 1}, 2),
                Arguments.of(new int[]{0, 3, -1, 5, 10, 3, -2}, 10),
                Arguments.of(new int[]{-2, -3, -7, -5, -10, -1}, -1),
                Arguments.of(new int[]{1}, 1)
        );
    }

    //Task 5
    @ParameterizedTest
    @MethodSource
    void maxTwoValues(int[] input, int[] maxValues) {
        Assertions.assertThat(Homework.maxTwoValues(input))
                .isEqualTo(maxValues);
    }

    public static Stream<Arguments> maxTwoValues() {
        return Stream.of(
                Arguments.of(new int[]{0, 3, -1, 5, 10, 3, -2}, new int[]{10, 5}),
                Arguments.of(new int[]{-2, -3, -7, -5, -10, -1}, new int[]{-1, -2}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{2, 1}, new int[]{2, 1}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 1}),
                Arguments.of(new int[]{-2, -2, -1, -1}, new int[]{-1, -1})
        );
    }

}
