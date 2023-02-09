package com.joe.api.services;

import com.joe.api.models.Product;
import java.util.List;

public interface ProductService {

    public Product save(Product product);

    List<Product> getAll();

    Product getById(Long id);
}
