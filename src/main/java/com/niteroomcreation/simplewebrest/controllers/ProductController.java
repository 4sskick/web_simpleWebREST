package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.data.domains.Product;
import com.niteroomcreation.simplewebrest.models.data.services.ProductService;
import com.niteroomcreation.simplewebrest.views.responses.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

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
    public ResponseResult getProducts_edit() {

        ResponseResult resp = ResponseResult.getInstance();
        resp.setData(productService.getAll());

        return resp;
    }

    //make support request using RAW json body constructed
    @RequestMapping(value = "/product"
            , method = RequestMethod.POST
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult saveProduct(@RequestBody Product model) {

        ResponseResult resp = ResponseResult.getInstance();
        resp.setSingleData(productService.save(model));

        return resp;
    }

    @RequestMapping(value = "/product"
            , method = RequestMethod.GET
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult getProductById(@RequestParam(value = "id") Long productId) {

        ResponseResult resp = ResponseResult.getInstance();

        if (productService.getById(productId) != null)
            resp.setSingleData(productService.getById(productId));
        else {
            resp.setData(Collections.emptyList());
        }

        return resp;
    }

    @RequestMapping(value = "/product"
            , method = RequestMethod.DELETE
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseResult deleteProductById(@RequestBody Product model) {

        ResponseResult resp = ResponseResult.getInstance();

        if (getProductById(model.getId()).getData().size() != 0) {
            productService.deleteById(model.getId());

            resp.setData(productService.getAll());
        } else {
            resp.setCode(1);
            resp.setMessage("gagal dihapus");
        }

        return resp;
    }


}
