package com.example.mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

/**
 * Service that provides calculation tools for the MCP server.
 */
@Service
public class CalculationToolService {

    /**
     * Performs basic arithmetic operations.
     *
     * @param x The first operand
     * @param y The second operand
     * @param operation The operation to perform (add, subtract, multiply, divide)
     * @return The result of the calculation
     */
    @Tool(description = "Performs basic arithmetic operations (add, subtract, multiply, divide)")
    public double calculate(double x, double y, String operation) {
        switch (operation.toLowerCase()) {
            case "add":
                return x + y;
            case "subtract":
                return x - y;
            case "multiply":
                return x * y;
            case "divide":
                if (y == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return x / y;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation + 
                    ". Supported operations are: add, subtract, multiply, divide");
        }
    }
    
    /**
     * Calculates the square root of a number.
     *
     * @param value The number to calculate the square root of
     * @return The square root of the number
     */
    @Tool(description = "Calculates the square root of a number")
    public double squareRoot(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(value);
    }
    
    /**
     * Calculates the power of a number.
     *
     * @param base The base number
     * @param exponent The exponent
     * @return The result of base raised to the power of exponent
     */
    @Tool(description = "Calculates the power of a number (base raised to exponent)")
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
