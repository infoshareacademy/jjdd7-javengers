package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CategoryDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category updateCategory(Category category) {
        return entityManager.merge(category);
    }

    public Category getCategoryById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> getCategoriesList() {
        Query query = entityManager.createNamedQuery("Category.getCategoryList");
        return query.getResultList();
    }

    public Category findCategoryByName(String name) {
        Query query = entityManager.createNamedQuery("Category.findCategoryByName");
        query.setParameter("name", name);
        return (Category) query.getResultList().stream().findFirst().orElse(null);
    }

    public String[] getCategoryIds() {
        Query query = entityManager.createNamedQuery("Category.getCategoryIds");
        List<Long> categoryIdList = query.getResultList();
        return categoryIdList.stream().map(l -> l.toString()).toArray(String[]::new);
    }

    public List<Category> getCategoriesById(List<Long> ids) {
        Query query = entityManager.createNamedQuery("Category.findCategoryById");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
