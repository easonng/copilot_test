package com.example.mcp.tools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CalculationToolService class.
 */
public class CalculationToolServiceTests {

    private CalculationToolService calculationToolService;

    @BeforeEach
    void setUp() {
        calculationToolService = new CalculationToolService();
    }

    @ParameterizedTest
    @CsvSource({
        "10, 5, add, 15.0",
        "10, 5, subtract, 5.0",
        "10, 5, multiply, 50.0",
        "10, 5, divide, 2.0"
    })
    @DisplayName("Test basic arithmetic operations")
    void testCalculate(double x, double y, String operation, double expected) {
        double result = calculationToolService.calculate(x, y, operation);
        assertEquals(expected, result, 0.0001, "Calculation result should match expected value");
    }

    @Test
    @DisplayName("Test division by zero throws exception")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculationToolService.calculate(10, 0, "divide");
        });
        
        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain 'Cannot divide by zero'");
    }

    @Test
    @DisplayName("Test unknown operation throws exception")
    void testUnknownOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculationToolService.calculate(10, 5, "unknown");
        });
        
        String expectedMessage = "Unknown operation";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain 'Unknown operation'");
    }

    @Test
    @DisplayName("Test square root calculation")
    void testSquareRoot() {
        double result = calculationToolService.squareRoot(16);
        assertEquals(4.0, result, 0.0001, "Square root of 16 should be 4");
    }

    @Test
    @DisplayName("Test square root of negative number throws exception")
    void testSquareRootOfNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculationToolService.squareRoot(-1);
        });
        
        String expectedMessage = "Cannot calculate square root of a negative number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message should contain 'Cannot calculate square root of a negative number'");
    }

    @Test
    @DisplayName("Test power calculation")
    void testPower() {
        double result = calculationToolService.power(2, 3);
        assertEquals(8.0, result, 0.0001, "2 raised to the power of 3 should be 8");
    }
}
