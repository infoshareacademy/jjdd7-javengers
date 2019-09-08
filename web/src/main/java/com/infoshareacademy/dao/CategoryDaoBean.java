package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void loadCategory(List<Category> categories) {
    for (Category category : categories
    ) {
      entityManager.persist(category);
    }
  }
}
