package com.joe.api.services;

import com.joe.api.models.Product;
import com.joe.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(Long id) throws NoSuchElementException {
        return productRepo.findById(id).get();
    }

    @Override
    public Object update(Long id, Product update) {
        Product prod = productRepo.findById(id).get();
        prod.setName(update.getName());
        return productRepo.save(prod);
    }

    @Override
    public Object delete(Long id) {
        Product deleted = productRepo.findById(id).get();
        productRepo.deleteById(deleted.getId());
        return deleted;
    }
}
