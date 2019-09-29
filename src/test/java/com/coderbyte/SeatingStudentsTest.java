package com.coderbyte;

import com.codility.lessons.extensions.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(TimingExtension.class)
class SeatingStudentsTest {

    @ParameterizedTest
    @MethodSource("createTestDataSeatingStudents")
    void testSeatingStudents(int[] arr, int expected) {
        final int actual = SeatingStudents.SeatingStudents(arr);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestDataSeatingStudents() {
        return Stream.of(
                Arguments.of(new int[]{12, 2, 6, 7, 11}, 6),
                Arguments.of(new int[]{6, 4}, 4),
                Arguments.of(new int[]{8, 1, 8}, 6)
        );
    }

}