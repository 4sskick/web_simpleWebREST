package com.niteroomcreation.simplewebrest.controllers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by monta on 10/12/20
 * please make sure to use credit when you're using people's code
 */
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    void contextLoad(){
        Assertions.assertThat(productController).isNotNull();
    }

    @Test
    void getProducts() {

    }

    @Test
    void saveProduct() {
    }

    @Test
    void getProductById() {
    }
}