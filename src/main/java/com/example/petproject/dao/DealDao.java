package com.example.petproject.dao;

import com.example.petproject.model.Deal;
import com.example.petproject.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DealDao {

    @PersistenceContext
    private EntityManager em;
//todo add find by user ID in query
    public List<Deal> getAll(long userId) {
        TypedQuery<Deal> query = em.createQuery("""
                        select d from Deal d
                        """, Deal.class);
            //    .setParameter("userId", userId);

        return query.getResultList();
    }
}
