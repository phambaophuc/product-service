package org.pbp.productservice.mapper;

import org.pbp.productservice.dto.CategoryDto;
import org.pbp.productservice.dto.ProductDto;
import org.pbp.productservice.entity.Category;
import org.pbp.productservice.entity.Product;

public interface ProductMapper {

    static ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .categoryDto(
                        CategoryDto.builder()
                                .categoryId(product.getCategory().getCategoryId())
                                .categoryName(product.getCategory().getCategoryName())
                                .build()
                )
                .build();
    }

    static Product mapToProduct(ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
                .imageUrl(productDto.getImageUrl())
                .price(productDto.getPrice())
                .category(
                        Category.builder()
                                .categoryId(productDto.getCategoryDto().getCategoryId())
                                .categoryName(productDto.getCategoryDto().getCategoryName())
                                .build()
                )
                .build();
    }
}
