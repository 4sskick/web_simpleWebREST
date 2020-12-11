package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.Product;
import com.niteroomcreation.simplewebrest.models.data.services.ProductService;
import com.niteroomcreation.simplewebrest.views.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by monta on 04/12/20
 * please make sure to use credit when you're using people's code
 */

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products"
            , method = RequestMethod.GET
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> getProducts() {
        return new BaseResponse(productService.getAll()).constructResponses();
    }

    //make support request using RAW json body constructed
    @RequestMapping(value = "/product"
            , method = RequestMethod.POST
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> saveProduct(@RequestBody Product model) {
//        return productService.save(model);
        return new BaseResponse(productService.save(model)).constructResponses();
    }

    @RequestMapping(value = "/product"
            , method = RequestMethod.GET
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> getProductById(@RequestParam(value = "id", defaultValue = "-1") Integer productId) {
//        return productService.getById(productId);
        return new BaseResponse(productService.getById(productId)).constructResponses();
    }

    @RequestMapping(value = "/product"
            , method = RequestMethod.DELETE
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductById(Product model) {

        if (getProductById(model.getId()) != null) {
            productService.deleteById(model.getId());
        } else {

        }
    }


}
