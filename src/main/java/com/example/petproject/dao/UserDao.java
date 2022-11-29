package com.example.petproject.dao;

import com.example.petproject.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    public User get(long userId) {
        return em.find(User.class, userId);
    }

    public User getUserWithContactList(long userId) {
      //  TypedQuery<User> query =
              return  em.createQuery("""
                        select u from User u
                        join fetch u.contactsList
                        where u.id=:userId
                        """, User.class)
                .setParameter("userId", userId).getSingleResult();
     //   return query.getSingleResult();
    }
}
