package org.pbp.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        log.info("** Category controller: find all category *");
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long categoryId) {
        log.info("** Category controller: find category by id *");
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        log.info("** Category controller: save category *");
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto) {
        log.info("** Category controller: update category *");
        return ResponseEntity.ok(categoryService.update(categoryDto));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteById(@PathVariable Long categoryId) {
        log.info("** Category controller: delete category by id *");
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok("Deleted Successfully!");
    }

}
