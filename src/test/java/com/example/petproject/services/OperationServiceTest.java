package com.example.petproject.services;

import com.example.petproject.model.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OperationServiceTest {
    private final OperationService operationService;

    @Autowired
    OperationServiceTest(OperationService operationService) {
        this.operationService = operationService;
    }

    @Test
    @DisplayName("Operation link to Deal")
    void getAll() {
        List<Operation> operations = operationService.getAll(1, 1);
        assertNotNull(operations);
        for (Operation operation : operations) {
            assertNotNull(operation.getDeal());
        }

    }
}