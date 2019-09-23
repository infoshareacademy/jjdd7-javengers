package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDaoBean;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.entity.User;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class UserService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  UserDaoBean userDaoBean;

  public void save(User user) {
    userDaoBean.save(user);
    logger.info("User has been saved");
  }

  public User updateUser(User user) {
    logger.info("User update");
    return userDaoBean.updateUser(user);
  }

  public User findUserByName(String name) {
    logger.info("Get user by name");
    return userDaoBean.findUserByName(name);
  }

  public User getUserById(Integer id) {
    logger.info("Get user by id");
    return userDaoBean.getUserById(id);
  }

  public void deleteUserById(Integer id) {
    userDaoBean.deleteUserById(id);
    logger.info("User has been deleted");
  }

  public List<User> getUsersList() {
    logger.info("Get users list");
    return userDaoBean.getUsersList();
  }

  public List<Recipe> getFavouritesList() {
    return userDaoBean.getFavouritesList();
  }
}
