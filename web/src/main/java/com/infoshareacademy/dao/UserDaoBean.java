package com.infoshareacademy.dao;

import com.infoshareacademy.domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadUsers(List<User> users) {
    for (User user : users
    ) {
      entityManager.persist(user);
    }
  }
}
