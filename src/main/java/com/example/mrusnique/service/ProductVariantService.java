package com.example.mrusnique.service;

import com.example.mrusnique.dto.ProductVariantDTO;
import com.example.mrusnique.model.OrderItem;
import com.example.mrusnique.model.Product;
import com.example.mrusnique.model.ProductVariant;
import com.example.mrusnique.repository.ProductRepository;
import com.example.mrusnique.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantService {

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductRepository productRepository;

    public ProductVariant createProductVariant(ProductVariantDTO productVariantDTO) {

        Product product = productRepository.findById(productVariantDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductVariant productVariant = new ProductVariant(
                product,
                productVariantDTO.getSize(),
                productVariantDTO.getColor(),
                productVariantDTO.getStock(),
                productVariantDTO.getAdditionalPrice()
        );

        return productVariantRepository.save(productVariant);
    }

    public List<ProductVariant> getAllProductVariants() {
        return productVariantRepository.findAll();
    }

    public Optional<ProductVariant> getProductVariantById(Long variantId) {
        return productVariantRepository.findById(variantId);
    }

    public ProductVariant updateProductVariant(Long variantId, ProductVariantDTO productVariantDTO) {

        ProductVariant productVariant = productVariantRepository.findById(variantId)
                .orElseThrow(() -> new RuntimeException("ProductVariant not found"));


        productVariant.setSize(productVariantDTO.getSize());
        productVariant.setColor(productVariantDTO.getColor());
        productVariant.setStock(productVariantDTO.getStock());
        productVariant.setAdditionalPrice(productVariantDTO.getAdditionalPrice());


        Product product = productRepository.findById(productVariantDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


        productVariant.setProduct(product);

        return productVariantRepository.save(productVariant);
    }

    public void deleteProductVariant(Long variantId) {
        productVariantRepository.deleteById(variantId);
    }

    public void setProductVariantForOrderItem(Long variantId, OrderItem orderItem) {
        ProductVariant productVariant = productVariantRepository.findById(variantId)
                .orElseThrow(() -> new RuntimeException("ProductVariant not found"));


        orderItem.setProductVariant(productVariant);
    }
}
