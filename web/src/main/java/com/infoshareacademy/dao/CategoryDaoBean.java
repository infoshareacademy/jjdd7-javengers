package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Category;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CategoryDaoBean {

  @PersistenceContext
  EntityManager entityManager;

  public void addCategory(Category category) {
    entityManager.persist(category);
  }

  public Category editCategory(Category category) {
    return entityManager.merge(category);
  }

  public Category getCategoryById(Long id) {
    return entityManager.find(Category.class, id);
  }

  public void deleteCategoryById(Long id) {
    Category category = getCategoryById(id);
    if (category != null) {
      entityManager.remove(category);
    }
  }
  public List<Category> getCategoriesList() {
    Query query = entityManager.createQuery("SELECT c FROM Category c");
    return query.getResultList();

  }

  public Category findCategoryByName(String name) {
    Query query = entityManager.createNamedQuery("Category.findCategoryByName");
    query.setParameter("name", name);

    List resultList = query.getResultList();
    if (resultList.size() > 0) {
      return (Category) resultList.get(0);
    } else {
      return null;
    }

//    return (Category) resultList.stream().findFirst().orElseGet(null);
  }
}
