package com.gustavoglins.desafiocruddorotech.domain.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    public Product(String name, String description, Double price, Integer amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer amount;
}
