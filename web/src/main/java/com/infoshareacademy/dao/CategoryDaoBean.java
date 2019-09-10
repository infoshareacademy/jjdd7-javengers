package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    return (Category) query.getResultList().stream().findFirst().orElse(null);
  }
}
