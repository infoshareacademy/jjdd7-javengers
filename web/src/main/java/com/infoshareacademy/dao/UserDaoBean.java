package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    public List<User> getUsersList() {
        Query query = entityManager.createNamedQuery("User.getUserList");
        return query.getResultList();
    }

    public User findUserByName(String name) {
        Query query = entityManager.createNamedQuery("User.findUserByName");
        query.setParameter("name", name);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }
}
