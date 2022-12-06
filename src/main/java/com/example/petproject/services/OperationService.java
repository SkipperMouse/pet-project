package com.example.petproject.services;

import com.example.petproject.dao.OperationDao;
import com.example.petproject.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OperationService {
    private final OperationDao operationDao;

    @Autowired
    public OperationService(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public List<Operation> getAll(long dealId, long userId){
        return operationDao.getAll(dealId, userId);
    }
}
