package com.infoshareacademy.dao;

import com.infoshareacademy.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public User editUser(User user) {
        return entityManager.merge(user);
    }

    public User getUserByName(String name) {
        return entityManager.find(User.class, name);
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

    public List<User> getUsersList() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();

    }
}
