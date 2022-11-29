package com.example.petproject.services;

import com.example.petproject.model.User;
import com.example.petproject.model.link_entities.UserDeal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest{
    @Autowired
   private UserService userService;


    @Test
    @DisplayName("Does db contains 4 users")
    public void getAll() {
        assertEquals(4, userService.getAll().size());
    }

    @Test
    @DisplayName("Get user with contact list")
    public void getUserWithContactList(){
        User user = userService.getUserWithContactList(1);
        assertNotNull(user);
        assertEquals(3, user.getContactsList().size());
    }

}