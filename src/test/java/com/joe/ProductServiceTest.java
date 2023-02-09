package com.joe;

import com.joe.api.models.Product;
import com.joe.api.services.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService ps;

    @Test
    public void getProducts(){
        List<Product> res = ps.getAll();
        assert res.size() == 2;
    }
}
