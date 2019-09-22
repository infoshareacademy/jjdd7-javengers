package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.User;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
@Transactional
public class SuperAdminInitializer {

  @EJB
  private UserService userService;

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PostConstruct
  protected void init() {
    User user = new User();
    user.setName("SuperAdmin");
    user.setSurname("JavengersTeam");
    user.setEmail("javengers.team@gmail.com");
    user.setUserType("admin");
    userService.save(user);
    logger.info("Super admin {}",user.getName() +" was created");
  }
}

