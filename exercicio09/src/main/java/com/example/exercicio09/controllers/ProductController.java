package com.example.exercicio9.controllers;

import com.example.exercicio9.dtos.ProductRequestDto;
import com.example.exercicio9.dtos.ProductResponseDto;
import com.example.exercicio9.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto saveProduct(@RequestBody @Valid ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @PatchMapping("/{id}")
    public ProductResponseDto patchProduct(@PathVariable UUID id, @RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.updateProduct(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
