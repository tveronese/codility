package com.codility.lessons.l02.oddoccurrencesinarray;

import com.codility.lessons.extensions.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(TimingExtension.class)
class SolutionTest {

    private static final Solution SOLUTION = new Solution();

    @ParameterizedTest
    @MethodSource("createTestData")
    void test(int[] array, int expected) {
        final int actual = SOLUTION.solution(array);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of(new int[]{9, 3, 9, 3, 9, 7, 9}, 7),
                Arguments.of(new int[]{9, 3, 3, 9, 7, 9, 9}, 7),
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{2, 1, 2}, 1),
                Arguments.of(new int[]{2, 3, 1, 4, 3, 2, 4}, 1),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, 2)
        );
    }

}