package com.example.petproject.services;

import com.example.petproject.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//Test annotation for test database initialization:
// https://stackoverflow.com/questions/56810477/init-database-before-tests-junit5-and-spring
@SpringBootTest
@SqlGroup(
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:database/init_db.sql"))
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    @DisplayName("Does db contains 4 users")
    void getAll() {
        assertEquals(4, userService.getAll().size());
    }

    @Test
    @DisplayName("Get user with contact list")
    void getUserWithContactList() {
        User user = userService.getUserWithContactList(1);
        assertNotNull(user);
        assertEquals(3, user.getContactsList().size());
    }

}