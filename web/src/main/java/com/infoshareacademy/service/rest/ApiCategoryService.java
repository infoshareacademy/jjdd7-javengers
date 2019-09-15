package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.dto.CategoryDto;
import com.infoshareacademy.mapper.CategoryEntityToDtoMapper;
import com.infoshareacademy.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiCategoryService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private CategoryService categoryService;

  @EJB
  private CategoryEntityToDtoMapper mapper;

  @Transactional
  public List<CategoryDto> getCategories() {
    logger.info("categories of recipes were mapped");
    List<CategoryDto> categories = new ArrayList<>();
    for (Category category : categoryService.getCategoriesList()) {
      categories.add(mapper.mapEntityToDto(category));
    }
    return categories;
  }
}
