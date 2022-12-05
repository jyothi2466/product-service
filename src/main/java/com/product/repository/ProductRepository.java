package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	public List<ProductEntity> findByName(String name);
	
	public ProductEntity findByProductCode(String productCode);

	public int deleteByName(String name);
}
