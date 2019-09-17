package com.infoshareacademy.service.rest;

import com.infoshareacademy.dto.CategoryDto;
import com.infoshareacademy.mapper.CategoryEntityToDtoMapper;
import com.infoshareacademy.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiCategoryService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private CategoryService categoryService;

  @EJB
  private CategoryEntityToDtoMapper mapper;

  public List<CategoryDto> getCategories() {
    logger.info("categories of recipes were mapped");
    List<CategoryDto> categories = new ArrayList<>();
    categoryService.getCategoriesList().forEach(i -> categories.add(mapper.mapEntityToDto(i)));
    return categories;
  }
}
