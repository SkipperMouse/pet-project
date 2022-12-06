package com.example.petproject.services;

import com.example.petproject.dao.UserDao;
import com.example.petproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User get(long userId) {
        return userDao.get(userId);
    }

    public User getUserWithContactList(long userId) {
        return userDao.getUserWithContactList(userId);
    }

    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }

    @Transactional
    public User update(User user) {
        return userDao.save(user);
    }

    @Transactional
    public boolean delete(long id) {
        return userDao.delete(id);
    }

}
