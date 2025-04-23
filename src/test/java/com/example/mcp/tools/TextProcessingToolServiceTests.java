package com.example.mcp.tools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the TextProcessingToolService class.
 */
public class TextProcessingToolServiceTests {

    private TextProcessingToolService textProcessingToolService;

    @BeforeEach
    void setUp() {
        textProcessingToolService = new TextProcessingToolService();
    }

    @Test
    @DisplayName("Test toUpperCase method")
    void testToUpperCase() {
        String result = textProcessingToolService.toUpperCase("Hello World");
        assertEquals("HELLO WORLD", result, "Text should be converted to uppercase");
    }

    @Test
    @DisplayName("Test toLowerCase method")
    void testToLowerCase() {
        String result = textProcessingToolService.toLowerCase("Hello World");
        assertEquals("hello world", result, "Text should be converted to lowercase");
    }

    @Test
    @DisplayName("Test reverse method")
    void testReverse() {
        String result = textProcessingToolService.reverse("Hello World");
        assertEquals("dlroW olleH", result, "Text should be reversed");
    }

    @ParameterizedTest
    @CsvSource({
        "'Hello World', 2",
        "'One Two Three Four', 4",
        "'', 0",
        "'   ', 0"
    })
    @DisplayName("Test countWords method")
    void testCountWords(String input, int expected) {
        int result = textProcessingToolService.countWords(input);
        assertEquals(expected, result, "Word count should match expected value");
    }

    @ParameterizedTest
    @CsvSource({
        "'hello world', 'Hello World'",
        "'HELLO WORLD', 'Hello World'",
        "'hello WORLD', 'Hello World'",
        "'', ''",
        "'hello', 'Hello'"
    })
    @DisplayName("Test capitalizeWords method")
    void testCapitalizeWords(String input, String expected) {
        String result = textProcessingToolService.capitalizeWords(input);
        assertEquals(expected, result, "Words should be capitalized correctly");
    }
}
