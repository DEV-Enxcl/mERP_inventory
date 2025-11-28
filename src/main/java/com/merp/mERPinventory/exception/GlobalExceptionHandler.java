package com.merp.mERPinventory.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<?> handleDataAccessException(DataAccessException ex) {

        ex.printStackTrace(); // For backend console debugging

        String message = extractUserFriendlyMessage(ex);

        return ResponseEntity.badRequest().body(
                Map.of("success", false, "message", message)
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {

        ex.printStackTrace(); // Backend log only

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "success", false,
                        "message", "An unexpected error occurred. Please try again."
                ));
    }

    // -------- Helper: Convert technical SQL exceptions to readable messages -------
    private String extractUserFriendlyMessage(DataAccessException ex) {

        String msg = ex.getRootCause() != null 
                    ? ex.getRootCause().getMessage()
                    : ex.getMessage();

        // FOREIGN KEY VIOLATION
        if (msg.contains("foreign key constraint")) {
            if (msg.contains("uom")) {
                return "Invalid UOM selected.";
            } else if (msg.contains("inventory_category")) {
                return "Invalid inventory category selected.";
            }
            return "Invalid reference used.";
        }

        // UNIQUE constraint / duplicate
        if (msg.contains("duplicate key")) {
            return "Record already exists.";
        }

        // NULL column
        if (msg.contains("null value")) {
            return "Required field missing.";
        }

        // Numeric conversion
        if (msg.contains("invalid input syntax for type numeric")) {
            return "Quantity or threshold must be a valid number.";
        }

        // Fallback
        return "Invalid data. Please check your input.";
    }
}
