package com.example.mrusnique.repository;

import com.example.mrusnique.model.ProductImage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findByProduct_ProductId(Integer productId);
    @Query("SELECT pi FROM ProductImage pi JOIN pi.product p ORDER BY p.createdAt DESC")
    List<ProductImage> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
