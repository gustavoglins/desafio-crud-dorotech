package com.gustavoglins.desafiocruddorotech.service;

import com.gustavoglins.desafiocruddorotech.domain.product.Product;
import com.gustavoglins.desafiocruddorotech.dto.CreateProductRequestDTO;
import com.gustavoglins.desafiocruddorotech.dto.UpdateProductRequestDTO;

import java.util.List;

public interface ProductService {

    Product create(CreateProductRequestDTO data) throws Exception;

    Product update(UpdateProductRequestDTO data) throws Exception;

    List<Product> listAll();

    Product queryById(Long id);

    void delete(Long id);
}
