package com.niteroomcreation.simplewebrest.models.data.services;

import com.niteroomcreation.simplewebrest.models.data.domains.User;
import com.niteroomcreation.simplewebrest.models.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by monta on 15/12/20
 * please make sure to use credit when you're using people's code
 */
public class UserService implements IService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User save(User model) {
        return repository.save(model);
    }

    @Override
    public User getById(Long id) {
        if (repository.existsById(id))
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User getByName(String name) {
        return repository.getByName(name);
    }
}
