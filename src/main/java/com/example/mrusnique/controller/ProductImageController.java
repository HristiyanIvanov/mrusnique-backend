package com.example.mrusnique.controller;

import com.example.mrusnique.dto.ProductImageDTO;
import com.example.mrusnique.model.ProductImage;
import com.example.mrusnique.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @PostMapping("/sync")
    public ResponseEntity<ProductImage> syncProductImage(@RequestBody ProductImageDTO productImageDTO) {
        ProductImage savedProductImage = productImageService.saveProductImage(productImageDTO);
        return ResponseEntity.ok(savedProductImage);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<ProductImage> getProductImage(@PathVariable Integer imageId) {
        ProductImage productImage = productImageService.getProductImageById(imageId);
        return ResponseEntity.ok(productImage);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductImage>> getProductImagesByProduct(@PathVariable Integer productId) {
        List<ProductImage> productImages = productImageService.getProductImagesByProductId(productId);
        return ResponseEntity.ok(productImages);
    }

    @PutMapping("/{imageId}/update")
    public ResponseEntity<ProductImage> updateProductImage(@PathVariable Integer imageId, @RequestBody ProductImageDTO productImageDTO) {
        ProductImage updatedProductImage = productImageService.updateProductImage(imageId, productImageDTO);
        return ResponseEntity.ok(updatedProductImage);
    }

    @DeleteMapping("/{imageId}/delete")
    public ResponseEntity<String> deleteProductImage(@PathVariable Integer imageId) {
        productImageService.deleteProductImage(imageId);
        return ResponseEntity.ok("Product image deleted successfully");
    }
}
