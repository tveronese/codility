package com.codility.lessons.l03.frogjump;

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
    void test(int initial, int target, int jumpDistance, int expected) {
        final int actual = SOLUTION.solution(initial, target, jumpDistance);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of(10, 85, 30, 3),
                Arguments.of(100, 130, 30, 1),
                Arguments.of(100, 130, 1, 30),
                Arguments.of(100, 130, 4, 8)
        );
    }

}