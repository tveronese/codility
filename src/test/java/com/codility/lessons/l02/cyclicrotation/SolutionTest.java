package com.codility.lessons.l02.cyclicrotation;

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
    void test(int[] array, int rotations, int[] expected) {
        final int[] actual = SOLUTION.solution(array, rotations);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}),
                Arguments.of(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}),
                Arguments.of(new int[]{1, 2, 3, 4}, 3, new int[]{2, 3, 4, 1}),
                Arguments.of(new int[]{}, 3, new int[]{})
        );
    }

}