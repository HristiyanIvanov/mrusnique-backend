package com.example.mrusnique.controller;

import com.example.mrusnique.dto.ProductVariantDTO;
import com.example.mrusnique.model.ProductVariant;
import com.example.mrusnique.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/variants")
public class ProductVariantController {

    @Autowired
    private ProductVariantService productVariantService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductVariant createProductVariant(@RequestBody ProductVariantDTO productVariantDTO) {
        return productVariantService.createProductVariant(productVariantDTO);
    }

    @GetMapping
    public List<ProductVariant> getAllProductVariants() {
        return productVariantService.getAllProductVariants();
    }

    @GetMapping("/{id}")
    public Optional<ProductVariant> getProductVariantById(@PathVariable Long id) {
        return productVariantService.getProductVariantById(id);
    }

    @PutMapping("/{id}")
    public ProductVariant updateProductVariant(@PathVariable Long id, @RequestBody ProductVariantDTO productVariantDTO) {
        return productVariantService.updateProductVariant(id, productVariantDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductVariant(@PathVariable Long id) {
        productVariantService.deleteProductVariant(id);
    }
}
