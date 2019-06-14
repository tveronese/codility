package com.codility.lessons.l01.binarygap;

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
    void test(int number, int expected) {
        final int actual = SOLUTION.solution(number);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of(1041, 5),
                Arguments.of(22, 1),
                Arguments.of(4232, 4),
                Arguments.of(328, 2),
                Arguments.of(51712, 2),
                Arguments.of(20, 1),
                Arguments.of(1610612737, 28),
                Arguments.of(1376796946, 5)
        );
    }

}