package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDaoBean;
import com.infoshareacademy.domain.User;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserService {

  @Inject
  UserDaoBean userDaoBean;

  public void addUser(User user) {
    userDaoBean.addUser(user);
  }

  public User editUser(User user) {
    return userDaoBean.editUser(user);
  }

  public User getUserByName(String name) {
    return userDaoBean.getUserByName(name);
  }

  public User getUserById(Integer id) {
    return userDaoBean.getUserById(id);
  }

  public void deleteUserById(Integer id) {
    userDaoBean.deleteUserById(id);
  }

  public List<User> getUsersList() {
    return userDaoBean.getUsersList();
  }
}
