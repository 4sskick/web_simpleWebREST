package com.niteroomcreation.simplewebrest.models.data.services;

import com.niteroomcreation.simplewebrest.models.data.domains.Role;
import com.niteroomcreation.simplewebrest.models.data.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by monta on 15/12/20
 * please make sure to use credit when you're using people's code
 */
public class RoleService implements IService<Role> {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Role save(Role model) {
        return repository.save(model);
    }

    @Override
    public Role getById(Long id) {
        if (repository.existsById(id))
            return repository.findById(id).get();
        else return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
