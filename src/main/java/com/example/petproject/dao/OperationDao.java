package com.example.petproject.dao;

import com.example.petproject.model.Deal;
import com.example.petproject.model.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationDao {

    @PersistenceContext
    private EntityManager em;

    //todo add filter by user to querry
    public List<Operation> getAll(long dealId, long userId) {
        TypedQuery<Operation> query = em.createQuery("""
                        select o from Operation o                        
                        where 
                        o.deal.id=:dealId
                        """, Operation.class)
                .setParameter("dealId", dealId);
//                .setParameter("userId", userId)

        return query.getResultList();
    }
}
