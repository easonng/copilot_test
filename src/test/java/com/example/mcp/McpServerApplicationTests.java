package com.example.mcp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

import com.example.mcp.tools.CalculationToolService;
import com.example.mcp.tools.TextProcessingToolService;

/**
 * Integration tests for the MCP Server application.
 */
@SpringBootTest
public class McpServerApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context, "Application context should not be null");
    }

    @Test
    void toolServicesAreRegistered() {
        assertTrue(context.containsBean("calculationToolService"), 
                "CalculationToolService should be registered as a bean");
        assertTrue(context.containsBean("textProcessingToolService"), 
                "TextProcessingToolService should be registered as a bean");
    }

    @Test
    void toolCallbackProvidersAreRegistered() {
        assertTrue(context.containsBean("calculationTools"), 
                "calculationTools bean should be registered");
        assertTrue(context.containsBean("textProcessingTools"), 
                "textProcessingTools bean should be registered");
    }

    @Test
    void toolServicesCanBeAutowired() {
        assertNotNull(context.getBean(CalculationToolService.class), 
                "CalculationToolService should be autowirable");
        assertNotNull(context.getBean(TextProcessingToolService.class), 
                "TextProcessingToolService should be autowirable");
    }
}
