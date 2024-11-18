package com.example.mrusnique.service;

import com.example.mrusnique.dto.ProductImageDTO;
import com.example.mrusnique.model.ProductImage;
import com.example.mrusnique.repository.ProductImageRepository;
import com.example.mrusnique.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductService productService;

    public ProductImage saveProductImage(ProductImageDTO productImageDTO) {
        Optional<Product> product = productService.getProductById(Long.valueOf(productImageDTO.getProductId()));
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        ProductImage productImage = new ProductImage();
        productImage.setProduct(product);
        productImage.setImageUrl(productImageDTO.getImageUrl());

        return productImageRepository.save(productImage);
    }

    public List<ProductImage> getProductImagesByProductId(Integer productId) {
        return productImageRepository.findByProduct_ProductId(productId);
    }

    public ProductImage getProductImageById(Integer imageId) {
        Optional<ProductImage> productImage = productImageRepository.findById(imageId);
        if (productImage.isPresent()) {
            return productImage.get();
        } else {
            throw new IllegalArgumentException("Product Image not found");
        }
    }

    public void deleteProductImage(Integer imageId) {
        if (productImageRepository.existsById(imageId)) {
            productImageRepository.deleteById(imageId);
        } else {
            throw new IllegalArgumentException("Product Image not found");
        }
    }

    public ProductImage updateProductImage(Integer imageId, ProductImageDTO productImageDTO) {
        ProductImage existingImage = getProductImageById(imageId);
        existingImage.setImageUrl(productImageDTO.getImageUrl());

        Optional<Product> product = productService.getProductById(Long.valueOf(productImageDTO.getProductId()));
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        existingImage.setProduct(product);
        return productImageRepository.save(existingImage);
    }
}
