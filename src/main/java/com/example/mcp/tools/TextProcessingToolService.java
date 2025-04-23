package com.example.mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Service that provides text processing tools for the MCP server.
 */
@Service
public class TextProcessingToolService {

    /**
     * Converts text to uppercase.
     *
     * @param input The text to convert
     * @return The uppercase version of the input text
     */
    @Tool(description = "Converts text to uppercase")
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }
    
    /**
     * Converts text to lowercase.
     *
     * @param input The text to convert
     * @return The lowercase version of the input text
     */
    @Tool(description = "Converts text to lowercase")
    public String toLowerCase(String input) {
        return input.toLowerCase();
    }
    
    /**
     * Reverses the input text.
     *
     * @param input The text to reverse
     * @return The reversed text
     */
    @Tool(description = "Reverses the input text")
    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    
    /**
     * Counts the number of words in the input text.
     *
     * @param input The text to count words in
     * @return The number of words in the text
     */
    @Tool(description = "Counts the number of words in the input text")
    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }
    
    /**
     * Capitalizes the first letter of each word in the input text.
     *
     * @param input The text to capitalize
     * @return The text with the first letter of each word capitalized
     */
    @Tool(description = "Capitalizes the first letter of each word in the input text")
    public String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        return Arrays.stream(input.split("\\s+"))
                .map(word -> word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
