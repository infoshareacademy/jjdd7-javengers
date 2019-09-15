package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private CategoryDaoBean categoryDaoBean;

    public void save(Category category) {
        categoryDaoBean.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryDaoBean.updateCategory(category);
    }

    public Category getCategoryById(Long id) {
        return categoryDaoBean.getCategoryById(id);
    }

    public List<Category> getCategoriesList() {
        return categoryDaoBean.getCategoriesList();
    }

    public Category findCategoryByName(String name) {
        return categoryDaoBean.findCategoryByName(name);
    }

    public String[] getCategoryIds() {
        return categoryDaoBean.getCategoryIds();
    }
}