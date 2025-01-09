package cz.cuni.mff.milotovl.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;

public class CalcTest {
    static Arguments[] assignmentExamplesInputs() {
        return new Arguments[]{
                Arguments.of("3 + 2", "5.00000"),
                Arguments.of("1e2", "100.00000"),
                Arguments.of("2 * ( 3 + 1 )", "8.00000"),
                Arguments.of("1.2 + 4.3", "5.50000"),
                //Arguments.of("3 ** 5", "výjimka"),
                Arguments.of("5 / 3", "1.66667"),
                //Arguments.of("x = 1 + 1", "2.00000"),
                //Arguments.of("3 + x", "5.00000"),
                //Arguments.of("last", "5.00000"),
                //Arguments.of("x", "2.00000"),
                //Arguments.of("y", "0.00000"),
                //Arguments.of("x + y", "2.00000"),
                //Arguments.of("ahoj = 1-2", "-1.00000"),
                //Arguments.of("last = x+ahoj", "1.00000"),
                Arguments.of("( ( 1 + 2 ) * 3 ) - 1", "8.00000"),
                Arguments.of("1 / 3", "0.33333"),
                Arguments.of("1e1-1e-1", "9.90000")
        };
    }

    @ParameterizedTest
    @MethodSource(
            "assignmentExamplesInputs"
    )
    void assignmentExamplesTest(String input, String expectedResult) {
        Calc calc = new Calc();
        String result = calc.execute(input);
        Assertions.assertEquals(expectedResult, result);
    }
}
