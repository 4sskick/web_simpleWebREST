package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.Product;
import com.niteroomcreation.simplewebrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product saveProduct(Product model) {
        return productService.save(model);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product getProductById(@RequestParam(required = true, value = "id", defaultValue = "-1") Integer productId) {

        if (String.valueOf(productId).equals("-1") || productId < 0)
            return new Product(-1, "here empty class product", -99.99f);

        return productService.getById(productId);
    }


}
