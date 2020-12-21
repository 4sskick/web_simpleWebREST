package com.niteroomcreation.simplewebrest.models.data.services;

import com.niteroomcreation.simplewebrest.models.data.domains.Product;

import java.util.List;

/**
 * Created by monta on 15/12/20
 * please make sure to use credit when you're using people's code
 */
public interface IService<S> {

    List<S> getAll();

    S save(S model);

    S getById(Long id);

    void deleteById(Long id);

    default S getByName(String name){
        return null;
    }
}
