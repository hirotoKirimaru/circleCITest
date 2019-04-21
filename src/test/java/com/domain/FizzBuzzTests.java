package com.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class FizzBuzzTests {

    @Autowired
    FizzBuzz testClass;

    static String FIZZ = "Fizz";
    static String BUZZ = "Buzz";
    static String FIZZBUZZ = "FizzBuzz";

    @ParameterizedTest
    @MethodSource("fizzBuzzParameterize")
    public void fizzBuzzTest(int input, String expect) {
        assertEquals(expect, testClass.exec(input));
    }

    private static Stream<Arguments> fizzBuzzParameterize() {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(2, "2"),
                Arguments.of(3, FIZZ),
                Arguments.of(4, "4"),
                Arguments.of(5, BUZZ),
                Arguments.of(6, FIZZ),
                Arguments.of(7, "7"),
                Arguments.of(8, "8"),
                Arguments.of(9, FIZZ),
                Arguments.of(10, BUZZ),
                Arguments.of(11, "11"),
                Arguments.of(12, FIZZ),
                Arguments.of(13, "13"),
                Arguments.of(14, "14"),
                Arguments.of(15, FIZZBUZZ),
                Arguments.of(16, "16"),
                Arguments.of(17, "17"),
                Arguments.of(18, FIZZ),
                Arguments.of(19, "19"),
                Arguments.of(20, BUZZ),
                Arguments.of(21, FIZZ),
                Arguments.of(22, "22"),
                Arguments.of(23, "23"),
                Arguments.of(24, FIZZ),
                Arguments.of(25, BUZZ),
                Arguments.of(26, "26"),
                Arguments.of(27, FIZZ),
                Arguments.of(28, "28"),
                Arguments.of(29, "29"),
                Arguments.of(30, FIZZBUZZ),
                Arguments.of(31, "31")
        );
    }
}
