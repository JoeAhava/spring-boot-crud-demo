package com.joe.api.services;

import com.joe.api.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/products")
public class ProductService {
    private static Map<String, Product> repo= new HashMap<>();
    static {
        Product tv = new Product();
        tv.setId(UUID.randomUUID().toString());
        tv.setName("Samsung TV");
        repo.put(tv.getId(), tv);
        Product headset = new Product();
        headset.setId(UUID.randomUUID().toString());
        headset.setName("Beats by dray");
        repo.put(headset.getId(), headset);
    }
    @GetMapping(value = "/")
    public ResponseEntity<Collection<Product>> getProducts(){
        ResponseEntity<Collection<Product>> res = new ResponseEntity<>(repo.values(), HttpStatus.OK);

        return res;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Map<String, Product>> addProduct(@RequestBody Product product){
        Product prod = new Product();
        prod.setId(UUID.randomUUID().toString());
        prod.setName(product.getName());
        repo.put(prod.getId(), prod);
        Map<String, Product> res = new HashMap<>();
        res.put("created", prod);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Map<String, Product>> updateProduct(@RequestBody Product product, @PathVariable String id){
        Product prod = repo.get(id);
        prod.setName(product.getName());
        repo.put(prod.getId(), prod);

        Map<String, Product> res = new HashMap<>();
        res.put("updated", prod);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Map<String, Product>> deleteProduct(@PathVariable String id){
        Product deleted = repo.get(id);
        repo.remove(id);
        Map<String, Product> res = new HashMap<>();
        res.put("deleted", deleted);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
