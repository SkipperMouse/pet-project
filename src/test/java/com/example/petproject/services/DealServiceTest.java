package com.example.petproject.services;

import com.example.petproject.model.Deal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DealServiceTest{
    @Autowired
    private DealService dealService;
    @Test
    @DisplayName("Select deals for right user")
    void getAll() {
        List<Deal> dealsUser1 = dealService.getAll(1);
        List<Deal> dealsUser2 = dealService.getAll(4);
        assertNotNull(dealsUser1);

        assertAll(
                () -> assertEquals(2, dealsUser1.size()),
                () ->assertEquals(1, dealsUser2.size())
        );
    }
}