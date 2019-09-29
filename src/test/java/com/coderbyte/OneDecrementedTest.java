package com.coderbyte;

import com.codility.lessons.extensions.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(TimingExtension.class)
class OneDecrementedTest {

    @ParameterizedTest
    @MethodSource("createTestDataOneDecremented")
    void testOneDecremented(String str, int expected) {
        final int actual = OneDecremented.OneDecremented(str);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestDataOneDecremented() {
        return Stream.of(
                Arguments.of("6", 0),
                Arguments.of("56", 0),
                Arguments.of("5655984", 2),
                Arguments.of("9876541110", 6)
        );
    }

}