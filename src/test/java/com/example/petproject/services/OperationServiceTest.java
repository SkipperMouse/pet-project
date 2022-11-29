package com.example.petproject.services;

import com.example.petproject.model.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OperationServiceTest{
    private final OperationService operationService;

    @Autowired
    OperationServiceTest(OperationService operationService) {
        this.operationService = operationService;
    }

    @Test
    @DisplayName("Operation link to Deal")
    void getAll() {
        List<Operation> operationsUser1Deal1 = operationService.getAll(1, 1);
        List<Operation> operationsUser2Deal2 = operationService.getAll(2, 2);
        List<Operation> operationUser4Deal1 = operationService.getAll(1, 4);

        assertAll(
                () -> assertEquals(1, operationsUser1Deal1.size()),
                () -> assertEquals(2, operationsUser2Deal2.size()),
                () -> assertEquals(0, operationUser4Deal1.size())
        );
    }
}