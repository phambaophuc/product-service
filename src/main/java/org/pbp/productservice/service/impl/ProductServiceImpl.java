package org.pbp.productservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.productservice.dto.ProductDto;
import org.pbp.productservice.exception.ProductNotFoundException;
import org.pbp.productservice.mapper.ProductMapper;
import org.pbp.productservice.repository.ProductRepo;
import org.pbp.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public List<ProductDto> findAll() {
        log.info("** Product service: find all products *");
        return productRepo.findAll()
                .stream()
                .map(ProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long productId) {
        log.info("** Product service: find product by id *");
        return productRepo.findById(productId)
                .map(ProductMapper::mapToDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " not found."));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        log.info("** Product service: save product *");
        return ProductMapper.mapToDto(productRepo.save(ProductMapper.mapToProduct(productDto)));
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        log.info("** Product service: update product *");
        return ProductMapper.mapToDto(productRepo.save(ProductMapper.mapToProduct(productDto)));
    }

    @Override
    public void deleteById(Long productId) {
        log.info("** Product service: delete product by id *");
        productRepo.deleteById(productId);
    }
}
