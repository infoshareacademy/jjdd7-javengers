package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.Category;
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

    public void loadCategory(List<Category> categories) {
        categoryDaoBean.loadCategory(categories);
        logger.info("Recipe categories list has been loaded");
    }

    public void addCategory(Category category) {
        categoryDaoBean.addCategory(category);
        logger.info("Recipe category has been saved");
    }

    public Category editCategory(Category category) {

        return categoryDaoBean.editCategory(category);
    }

    public Category getCategoryByName(String name) {
        logger.info("Get recipe category by name");
        return categoryDaoBean.getCategoryByName(name);
    }

    public Category getCategoryById(Long id) {
        logger.info("Get recipe category by id");
        return categoryDaoBean.getCategoryById(id);
    }

    public void deleteCategoryById(Long id) {
        categoryDaoBean.deleteCategoryById(id);
        logger.info("Category has been deleted");
    }

    public List<Category> getCategoriesList() {
        logger.info("Get recipe categories list");
        return categoryDaoBean.getCategoriesList();
    }
}
