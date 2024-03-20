package org.pbp.productservice.service;

import org.pbp.productservice.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long productId);
    ProductDto save(ProductDto productDto);
    ProductDto update(ProductDto productDto);
    void deleteById(Long productId);
}
