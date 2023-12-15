package com.onlineShoppingAPI.productService.service;

import com.onlineShoppingAPI.productService.dto.ProductRequest;
import com.onlineShoppingAPI.productService.dto.ProductResponse;
import com.onlineShoppingAPI.productService.model.Product;
import com.onlineShoppingAPI.productService.repositiry.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//for logging info - lombok
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product " + product.getId() + " is created");
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> {
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .build();
        }).toList();
    }
}
