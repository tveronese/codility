package com.codility.lessons.l03.permmissingelem;

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
    void test(int[] numbers, int expected) {
        final int actual = SOLUTION.solution(numbers);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        final int[] large = new int[100000];
        for (int i = 0; i < large.length; i++) {
            large[i] = i + 1;
        }
        return Stream.of(
                Arguments.of(new int[]{2, 3, 1, 5}, 4),
                Arguments.of(new int[]{2, 3, 1, 5, 6, 9, 8, 7}, 4),
                Arguments.of(large, large.length + 1)
        );
    }

}