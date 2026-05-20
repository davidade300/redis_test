package com.redislearn.produtos.services;

import com.redislearn.produtos.dto.ProductDto;
import com.redislearn.produtos.entities.Product;
import com.redislearn.produtos.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#id")
    public ProductDto getProductById(Long id) {
        log.info("Getting product by id {}", id);
        simulateLatency();
        Product product = productRepository.findById(id).get();

        return new ProductDto(product.getId(), product.getName(), product.getCode());
    }

    protected void simulateLatency() {
        try {

            long time = 20000L;
            log.info("Simulating latency of {} ms", Duration.ofMillis(time));
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
