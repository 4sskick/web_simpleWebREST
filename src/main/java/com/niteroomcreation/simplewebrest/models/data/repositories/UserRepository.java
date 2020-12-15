package com.niteroomcreation.simplewebrest.models.data.repositories;

import com.niteroomcreation.simplewebrest.models.data.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by monta on 15/12/20
 * please make sure to use credit when you're using people's code
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
