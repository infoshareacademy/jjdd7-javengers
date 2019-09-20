package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
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
        logger.info("ingredients with name contains " + name + " found in database");
        return categoryDaoBean.findCategoryByName(name);
    }

    public String[] getCategoryIds() {
        return categoryDaoBean.getCategoryIds();
    }

    public List<Category> getCategoriesById(List<Long> ids) {
        return categoryDaoBean.getCategoriesById(ids);
    }
}