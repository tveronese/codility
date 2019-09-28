package com.codility.lessons.l07.brackets;

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
    void test(String S, int expected) {
        final int actual = SOLUTION.solution(S);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
                Arguments.of("", 1),
                Arguments.of("{[()()]}", 1),
                Arguments.of("{[()]}", 1),
                Arguments.of("[]", 1),
                Arguments.of("{}", 1),
                Arguments.of("()", 1),
                Arguments.of("(((())))", 1),
                Arguments.of("([((()))])", 1),
                Arguments.of("([)()]", 0),
                Arguments.of("]", 0),
                Arguments.of("{{{{", 0),
                Arguments.of("[", 0)
        );
    }


}