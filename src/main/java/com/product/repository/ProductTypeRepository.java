package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.entity.ProductTypeEntity;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, String>{

}
