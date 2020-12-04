package com.niteroomcreation.simplewebrest.data.repositories;

import com.niteroomcreation.simplewebrest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by monta on 04/12/20
 * please make sure to use credit when you're using people's code
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
