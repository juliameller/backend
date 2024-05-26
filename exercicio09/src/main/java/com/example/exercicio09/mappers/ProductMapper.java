package com.example.exercicio9.mappers;

import com.example.exercicio9.dtos.ProductResponseDto;
import com.example.exercicio9.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponseDto toResponseDTO(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
