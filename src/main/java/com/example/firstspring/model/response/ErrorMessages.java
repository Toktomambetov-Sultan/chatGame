package com.example.firstspring.model.response;

public enum ErrorMessages {
    MISSIN_REQUIRED_FIELD("Missing required field. Please check documentation for required field.");

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;
    ErrorMessages(String errorMessage) {
        this.errorMessage =errorMessage;
    }

}
