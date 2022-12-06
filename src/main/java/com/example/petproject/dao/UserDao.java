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
        return em.createQuery("""
                        select u from User u
                        join fetch u.contactsList
                        where u.id=:userId
                        """, User.class)
                .setParameter("userId", userId).getSingleResult();
    }

    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    public boolean delete(long id) {
        TypedQuery<User> query = em.createQuery("""
                            delete from User u
                            where u.id=:userId
                        """, User.class)
                .setParameter("userId", id);
        return query.executeUpdate() != 0;
    }


}
