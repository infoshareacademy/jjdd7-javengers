package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.User;
import java.util.Collections;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UsersPageService {

  public List<User> getUsersPerPage(int pageSize, int pageNumber, List<User> filterList) {

    if (pageSize <= 0 || pageNumber <= 0) {
      throw new IllegalArgumentException("invalid page size: " + pageSize);
    }
    int fromIndex = (pageNumber - 1) * pageSize;
    if (filterList == null || filterList.size() < fromIndex) {
      return Collections.emptyList();
    }
    return filterList.subList(fromIndex, Math.min(fromIndex + pageSize, filterList.size()));
  }

  public Integer getLastNumberPage(int pageSize, List<User> userList) {
    return (userList.size() + pageSize - 1) / pageSize;
  }
}






