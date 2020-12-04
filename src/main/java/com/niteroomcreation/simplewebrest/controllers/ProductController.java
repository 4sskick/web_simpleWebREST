package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.Product;
import com.niteroomcreation.simplewebrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by monta on 04/12/20
 * please make sure to use credit when you're using people's code
 */

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAll();
    }


}
