package com.joe;

import com.joe.api.models.Product;
import com.joe.api.services.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService ps;

    @Test
    public void getProducts(){
        ResponseEntity<Collection<Product>> res = ps.getProducts();
        assert res.getBody().size() == 2;
    }
}
