package com.example.petproject.utils;

import com.example.petproject.model.User;

import java.time.LocalDateTime;

public class TestUtils {
    public final static User USER1 = new User(101L, "t login1", "t password1", "t1@gmail.com", "t1 name", "t surname1", "t nickname1", LocalDateTime.now());
    public final static User USER2 = new User(102L, "t login2", "t password2", "t2@gmail.com", "t2 name", "t surname2", "t nickname2", LocalDateTime.now());
    public final static User USER3 = new User(103L, "t login3", "t password3", "t3@gmail.com", "t3 name", "t surname3", "t nickname3", LocalDateTime.now());
    public final static User NEW_USER = new User(0L, "new login4", "new password4", "new4@gmail.com", "new4 name", "new surname4", "new nickname4", LocalDateTime.now());



    static{
        NEW_USER.setId(null);
    }
}
