package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDaoBean;
import com.infoshareacademy.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class UserService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    UserDaoBean userDaoBean;

    public void loadUsers(List<User> users) {
        userDaoBean.loadUsers(users);
        logger.info("User has been loaded");
    }

    public void addUser(User user) {
        userDaoBean.addUser(user);
        logger.info("User has been saved");
    }

    public User editUser(User user) {
        logger.info("User update");
        return userDaoBean.editUser(user);
    }

    public User getUserByName(String name) {
        logger.info("Get user by name");
        return userDaoBean.getUserByName(name);
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
}
