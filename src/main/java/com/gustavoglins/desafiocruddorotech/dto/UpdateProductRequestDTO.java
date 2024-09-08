package com.gustavoglins.desafiocruddorotech.dto;

public record UpdateProductRequestDTO(Long id, String name, String description, Double price, Integer amount) {
}
