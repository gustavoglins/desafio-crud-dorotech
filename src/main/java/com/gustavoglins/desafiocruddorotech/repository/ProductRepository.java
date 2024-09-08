package com.gustavoglins.desafiocruddorotech.repository;

import com.gustavoglins.desafiocruddorotech.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
