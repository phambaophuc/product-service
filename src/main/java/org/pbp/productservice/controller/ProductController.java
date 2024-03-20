package org.pbp.productservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.productservice.dto.ProductDto;
import org.pbp.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        log.info("** Product controller: find all products *");
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long productId) {
        log.info("** Product controller: find product by id *");
        return ResponseEntity.ok(productService.findById(productId));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        log.info("** Product controller: save product *");
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        log.info("** Product controller: update product *");
        return ResponseEntity.ok(productService.update(productDto));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId) {
        log.info("** Product controller: delete product by id *");
        productService.deleteById(productId);
        return ResponseEntity.ok("Deleted Successfully!");
    }
}
