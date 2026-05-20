package com.redislearn.produtos.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * DTO for {@link com.redislearn.produtos.entities.Product}
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public record ProductDto(Long id, String name, Long code) implements Serializable {
}