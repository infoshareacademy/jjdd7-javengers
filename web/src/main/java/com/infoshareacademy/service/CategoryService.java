package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.Category;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CategoryService {

  @Inject
  private CategoryDaoBean categoryDaoBean;

    public void loadCategory(List<Category> categories) {
        categoryDaoBean.loadCategory(categories);
    }

    public void addCategory(Category category) {
        categoryDaoBean.addCategory(category);
    }

    public Category editCategory(Category category) {
        return categoryDaoBean.editCategory(category);
    }

    public Category getCategoryByName(String name) {
        return categoryDaoBean.getCategoryByName(name);
    }

    public Category getCategoryById(Long id) {
        return categoryDaoBean.getCategoryById(id);
    }

    public void deleteCategoryById(Long id) {
        categoryDaoBean.deleteCategoryById(id);
    }

    public List<Category> getCategoriesList() {
        return categoryDaoBean.getCategoriesList();
    }
}
