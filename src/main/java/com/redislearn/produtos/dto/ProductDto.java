package com.redislearn.produtos.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.redislearn.produtos.entities.Product}
 */
public record ProductDto(Long id, String name, Long code) implements Serializable {
}