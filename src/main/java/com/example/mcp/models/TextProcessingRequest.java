package com.example.mcp.models;

/**
 * Model class representing a text processing request.
 */
public class TextProcessingRequest {
    private String text;
    private String operation;

    public TextProcessingRequest() {
    }

    public TextProcessingRequest(String text, String operation) {
        this.text = text;
        this.operation = operation;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
