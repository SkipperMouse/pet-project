package com.example.petproject.services;

import com.example.petproject.dao.DealDao;
import com.example.petproject.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    private final DealDao dealDao;

    @Autowired
    public DealService(DealDao dealDao) {
        this.dealDao = dealDao;
    }

    public List<Deal> getAll(long userId) {
        return dealDao.getAll(userId);
    }
}
