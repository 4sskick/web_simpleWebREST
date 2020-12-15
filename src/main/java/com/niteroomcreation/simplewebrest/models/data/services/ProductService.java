package com.niteroomcreation.simplewebrest.models.data.services;

import com.niteroomcreation.simplewebrest.models.data.repositories.ProductRepository;
import com.niteroomcreation.simplewebrest.models.data.domains.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by monta on 04/12/20
 * please make sure to use credit when you're using people's code
 */

@Service
public class ProductService implements IService<Product>{

    @Autowired
    private ProductRepository repo;

    //operation DB
    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product save(Product model) {
        return repo.save(model);
    }

    public Product getById(Long id) {
        if (repo.findById(id).isPresent())
            return repo.findById(id).get();
        else
            return null;
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
