package com.example.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.MethodToolCallbackProvider;
import com.example.mcp.tools.CalculationToolService;
import com.example.mcp.tools.TextProcessingToolService;

/**
 * Main application class for the MCP Server.
 * This class configures the Spring Boot application and registers tool callbacks.
 */
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    /**
     * Registers calculation tools with the MCP server.
     * 
     * @param calculationToolService The calculation tool service
     * @return A ToolCallbackProvider for calculation tools
     */
    @Bean
    public ToolCallbackProvider calculationTools(CalculationToolService calculationToolService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(calculationToolService)
                .build();
    }
    
    /**
     * Registers text processing tools with the MCP server.
     * 
     * @param textProcessingToolService The text processing tool service
     * @return A ToolCallbackProvider for text processing tools
     */
    @Bean
    public ToolCallbackProvider textProcessingTools(TextProcessingToolService textProcessingToolService) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(textProcessingToolService)
                .build();
    }
}
