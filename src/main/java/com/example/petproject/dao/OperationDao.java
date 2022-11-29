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

    public List<Operation> getAll(long dealId, long userId) {
        TypedQuery<Operation> query = em.createQuery("""
                        select o from Operation o   
                        join fetch o.users as u                     
                        where 
                        o.deal.id=:dealId
                        and u.user.id=:userId
                        """, Operation.class)
                .setParameter("userId", userId)
                .setParameter("dealId", dealId);

        return query.getResultList();
    }
}
