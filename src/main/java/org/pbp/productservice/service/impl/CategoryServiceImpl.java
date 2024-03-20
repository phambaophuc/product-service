package org.pbp.productservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.exception.CategoryNotFoundException;
import org.pbp.productservice.mapper.CategoryMapper;
import org.pbp.productservice.repository.CategoryRepo;
import org.pbp.productservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryDto> findAll() {
        log.info("** Category service: find all categories *");
        return categoryRepo.findAll()
                .stream()
                .map(CategoryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long categoryId) {
        log.info("** Category service: find category by id *");
        return categoryRepo.findById(categoryId)
                .map(CategoryMapper::mapToDto)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found."));
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        log.info("** Category service: save category *");
        return CategoryMapper.mapToDto(categoryRepo.save(CategoryMapper.mapToCategory(categoryDto)));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        log.info("** Category service: update category *");
        return CategoryMapper.mapToDto(categoryRepo.save(CategoryMapper.mapToCategory(categoryDto)));
    }

    @Override
    public void deleteById(Long categoryId) {
        log.info("** Category service: delete category by id");
        categoryRepo.deleteById(categoryId);
    }
}
