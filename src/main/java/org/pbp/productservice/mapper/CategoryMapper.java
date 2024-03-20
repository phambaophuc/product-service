package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.entity.Category;

public interface CategoryMapper {

    static CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }

    static Category mapToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .categoryName(categoryDto.getCategoryName())
                .build();
    }
}
