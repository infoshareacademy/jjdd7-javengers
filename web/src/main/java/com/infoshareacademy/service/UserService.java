package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDaoBean;
import com.infoshareacademy.domain.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
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

  public User findUserByEmail(String email) {
    logger.info("Get user by name");
    return userDaoBean.findUserByEmail(email);
  }

  public User getUserById(Long id) {
    logger.info("Get user by id");
    return userDaoBean.getUserById(id);
  }

  public void deleteUserById(Long id) {
    userDaoBean.deleteUserById(id);
    logger.info("User has been deleted");
  }

  public List<User> getUsersList(){
    return userDaoBean.getUsersList();
  }

  public void editFavouritesByIdForUSer( Long recipeId, Long userId) {
    userDaoBean.editFavouritesByIdForUSer(recipeId, userId);
    logger.info("Recipe changed its favourites status");
  }
}
