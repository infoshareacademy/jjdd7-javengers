package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public User getUserById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public void deleteUserById(Integer id) {
        User recipe = getUserById(id);
        if (recipe != null) {
            entityManager.remove(recipe);
        }
    }

    public User findUserByEmail(String email) {
        Query query = entityManager.createNamedQuery("User.findUserByEmail");
        query.setParameter("email", email);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }
}
