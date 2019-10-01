package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.dto.CategoryDto;
import javax.ejb.Stateless;

@Stateless
public class CategoryEntityToDtoMapper {

  public CategoryDto mapEntityToDto(Category category) {

    CategoryDto categoryDto = new CategoryDto();
    categoryDto.setName(category.getName());
    return categoryDto;
  }
}
