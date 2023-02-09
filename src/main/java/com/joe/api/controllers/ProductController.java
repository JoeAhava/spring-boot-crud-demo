package com.joe.api.controllers;

import com.joe.api.models.Product;
import com.joe.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;
//    private static Map<String, Product> repo= new HashMap<>();
//    static {
//        Product tv = new Product();
//        tv.setId(UUID.randomUUID().toString());
//        tv.setName("Samsung TV");
//        repo.put(tv.getId(), tv);
//        Product headset = new Product();
//        headset.setId(UUID.randomUUID().toString());
//        headset.setName("Beats by dray");
//        repo.put(headset.getId(), headset);
//    }
    @GetMapping(value = "/")
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @PostMapping(value = "/")
    public Product addProduct(@RequestBody Product product){
//        Product prod = new Product();
//        prod.setId(UUID.randomUUID().toString());
//        prod.setName(product.getName());
//        repo.put(prod.getId(), prod);
//        Map<String, Product> res = new HashMap<>();
//        res.put("created", prod);
        return productService.save(product);
    }
//
    @PutMapping(value = "/{id}")
    public Object updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        try{
            return productService.update(id, product);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Product Not found", HttpStatus.NOT_FOUND);
        }
    }
//
    @DeleteMapping(value = "/{id}")
    public Object deleteProduct(@PathVariable Long id){
        try{
            return productService.delete(id);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Product Not found", HttpStatus.NOT_FOUND);
        }
    }
}
