package com.coderbyte;

import com.codility.lessons.extensions.TimingExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(TimingExtension.class)
class ShortestPathTest {

    @ParameterizedTest
    @MethodSource("createTestDataShortestPath")
    void testShortestPath(String[] arr, String expected) {
        final String actual = ShortestPath.ShortestPath(arr);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> createTestDataShortestPath() {
        return Stream.of(
                Arguments.of(new String[]{"4", "A", "B", "C", "D", "A-B", "B-D", "B-C", "C-D"}, "A-B-D"),
                Arguments.of(new String[]{"5", "A", "B", "C", "D", "F", "A-B", "A-C", "B-C", "C-D", "D-F"}, "A-C-D-F"),
                Arguments.of(new String[]{"4", "X", "Y", "Z", "W", "X-Y", "Y-Z", "X-W"}, "X-W"),
                Arguments.of(new String[]{"7", "A", "B", "C", "D", "E", "F", "G", "A-B", "A-E", "B-C", "C-D", "D-F", "E-D", "F-G"}, "A-E-D-F-G"),
                Arguments.of(new String[]{"7", "A", "B", "C", "D", "E", "F", "G", "A-B", "A-E", "B-C", "C-D", "F-G"}, "-1")
        );
    }

}