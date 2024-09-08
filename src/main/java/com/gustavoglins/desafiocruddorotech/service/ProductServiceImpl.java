package com.gustavoglins.desafiocruddorotech.service;

import com.gustavoglins.desafiocruddorotech.domain.product.Product;
import com.gustavoglins.desafiocruddorotech.dto.CreateProductRequestDTO;
import com.gustavoglins.desafiocruddorotech.dto.UpdateProductRequestDTO;
import com.gustavoglins.desafiocruddorotech.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean createProductValidation(CreateProductRequestDTO data) throws Exception {
        if (data.name() == null || data.name().isEmpty()) {
            throw new RuntimeException("Product name cannot be empty.");
        }

        if (data.description() == null || data.description().isEmpty()) {
            throw new RuntimeException("Product description cannot be empty.");
        }

        if (data.price() == null) {
            throw new RuntimeException("Product price cannot be empty.");
        }

        if (data.price() < 0) {
            throw new IllegalAccessException("Product price must be greater than 0.");
        }

        if (data.amount() == null) {
            throw new RuntimeException("Product amount cannot be empty.");
        }
        return true;
    }

    public boolean updateProductValidation(UpdateProductRequestDTO data) throws Exception {
        if (data.name() == null || data.name().isEmpty()) {
            throw new RuntimeException("Product name cannot be empty.");
        }

        if (data.description() == null || data.description().isEmpty()) {
            throw new RuntimeException("Product description cannot be empty.");
        }

        if (data.price() == null) {
            throw new RuntimeException("Product price cannot be empty.");
        }

        if (data.price() < 0) {
            throw new IllegalAccessException("Product price must be greater than 0.");
        }

        if (data.amount() == null) {
            throw new RuntimeException("Product amount cannot be empty.");
        }
        return true;
    }

    @Override
    public Product create(CreateProductRequestDTO data) throws Exception {

        if (createProductValidation(data)) {
            Product newProduct = new Product();
            newProduct.setName(data.name());
            newProduct.setDescription(data.description());
            newProduct.setPrice(data.price());
            newProduct.setAmount(data.amount());

            return productRepository.save(newProduct);
        }
        throw new Exception("Product not created.");
    }

    @Override
    public Product update(UpdateProductRequestDTO data) throws Exception {
        Optional<Product> existingProductOptional = productRepository.findById(data.id());

        if (existingProductOptional.isEmpty()) {
            throw new Exception("Product not found with ID: " + data.id());
        }

        Product selectedProduct = existingProductOptional.get();

        if (updateProductValidation(data)) {
            selectedProduct.setName(data.name());
            selectedProduct.setDescription(data.description());
            selectedProduct.setPrice(data.price());
            selectedProduct.setAmount(data.amount());

            return productRepository.save(selectedProduct);
        }

        throw new Exception("Product not updated.");
    }

    @Override
    public List<Product> listAll() {
        Sort sortByIdAsc = Sort.by(Sort.Direction.ASC, "id");

        return productRepository.findAll(sortByIdAsc);
    }

    @Override
    public Product queryById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found."));
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Product not found.");
        }
    }
}
