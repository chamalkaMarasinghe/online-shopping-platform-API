package com.onlineShoppingAPI.productService.service;

import com.onlineShoppingAPI.productService.dto.ProductRequest;
import com.onlineShoppingAPI.productService.model.Product;
import com.onlineShoppingAPI.productService.repositiry.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
//for logging info - lombok
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product " + product.getId() + " is created");
    }
}
