package org.pbp.productservice.service;

import org.pbp.productservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();
    CategoryDto findById(Long categoryId);
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto update(CategoryDto categoryDto);
    void deleteById(Long categoryId);
}
