package com.gustavoglins.desafiocruddorotech.dto;

public record CreateProductRequestDTO (String name, String description, Double price, Integer amount) {
}
