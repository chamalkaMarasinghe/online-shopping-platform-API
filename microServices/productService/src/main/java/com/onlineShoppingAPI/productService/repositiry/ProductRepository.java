package com.onlineShoppingAPI.productService.repositiry;

import com.onlineShoppingAPI.productService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
