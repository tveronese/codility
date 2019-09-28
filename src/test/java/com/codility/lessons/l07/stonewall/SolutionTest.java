package com.codility.lessons.l07.stonewall;

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
    void test(int[] heights, int expected) {
        final int actual = SOLUTION.solution(heights);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7)
        );
    }


}