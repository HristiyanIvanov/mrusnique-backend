package com.example.mrusnique.service;

import com.example.mrusnique.dto.ProductImageDTO;
import com.example.mrusnique.model.ProductImage;
import com.example.mrusnique.repository.ProductImageRepository;
import com.example.mrusnique.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.nio.file.*;

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

    public List<ProductImage> getAllProductImages() {
        return productImageRepository.findAll();
    }

    public List<ProductImage> getLatestProductImages(int count) {
        Pageable pageable = PageRequest.of(0, count, Sort.by(Sort.Order.desc("product.createdAt")));
        List<ProductImage> productImages = productImageRepository.findAllByOrderByCreatedAtDesc(pageable);
        return productImages;

    }

    private static final String UPLOAD_DIR = "uploads/";

    public ProductImage uploadProductImage(MultipartFile file, Integer productId) throws Exception {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.write(filePath, file.getBytes());

        Optional<Product> product = productService.getProductById((long) productId);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        ProductImage productImage = new ProductImage();
        productImage.setProduct(product);
        productImage.setImageUrl("/" + UPLOAD_DIR + fileName);

        return productImageRepository.save(productImage);
    }

    public ProductImage getProductImageById(Integer imageId) {
        Optional<ProductImage> productImage = productImageRepository.findById(imageId);
        if (productImage.isPresent()) {
            return productImage.get();
        } else {
            throw new IllegalArgumentException("Product Image not found");
        }
    }

    public List<ProductImage> getProductImagesByProductId(Integer productId) {
        return productImageRepository.findByProduct_ProductId(productId);
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
