package com.example.petproject.services;

import com.example.petproject.model.Deal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DealServiceTest {
    @Autowired
    private DealService dealService;
    @Test
    @DisplayName("Deal links to operation")
    void getAll() {
        List<Deal> deals = dealService.getAll(1);
        assertNotNull(deals);
        for (Deal deal :deals) {
            assertNotNull(deal.getOperations());
        }

    }
}