package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.entity.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @EJB
    private CategoryDaoBean categoryDaoBean;

    public void save(Category category) {
        categoryDaoBean.save(category);
    }

    @Transactional
    public Category updateCategory(Category category) {
        return categoryDaoBean.updateCategory(category);
    }

    public List<Category> getCategoriesList() {
        return categoryDaoBean.getCategoriesList();
    }

    @Transactional
    public Category findCategoryByName(String name) {
        logger.info("ingredients with name contains {} found in database", name);
        return categoryDaoBean.findCategoryByName(name);
    }

    public String[] getCategoryIds() {
        return categoryDaoBean.getCategoryIds();
    }
}