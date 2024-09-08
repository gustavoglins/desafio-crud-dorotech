package com.gustavoglins.desafiocruddorotech.controller;

import com.gustavoglins.desafiocruddorotech.domain.product.Product;
import com.gustavoglins.desafiocruddorotech.dto.CreateProductRequestDTO;
import com.gustavoglins.desafiocruddorotech.dto.UpdateProductRequestDTO;
import com.gustavoglins.desafiocruddorotech.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateProductRequestDTO data) throws Exception {
        productService.create(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateProductRequestDTO data) throws Exception {
        productService.update(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Product> listAll() {
        return productService.listAll();
    }

    @GetMapping("{id}")
    public Product queryById(@PathVariable Long id) {
        return productService.queryById(id);
    }

    @DeleteMapping("{id}")
    public void deleter(@PathVariable Long id) {
        productService.delete(id);
    }
}
