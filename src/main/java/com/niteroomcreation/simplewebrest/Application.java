package com.niteroomcreation.simplewebrest;

import com.niteroomcreation.simplewebrest.models.data.domains.Role;
import com.niteroomcreation.simplewebrest.models.data.domains.User;
import com.niteroomcreation.simplewebrest.models.data.repositories.RoleRepository;
import com.niteroomcreation.simplewebrest.models.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //begin role
        Role role = new Role();
        role.setName("Manager");

        if (roleRepo.getByName(role.getName()) == null)
            roleRepo.save(role);

        role = new Role();
        role.setName("HR");

        if (roleRepo.getByName(role.getName()) == null)
            roleRepo.save(role);

        role = new Role();
        role.setName("User");

        if (roleRepo.getByName(role.getName()) == null)
            roleRepo.save(role);

        //begin user
        User user = new User();
        user.setUserName("monta");
        user.setEmail("monta@email.com");
        user.setPassword("123qwe");
        user.setRole(roleRepo.getByName("Manager"));
        if (userRepo.getByName(user.getUserName()) == null)
            userRepo.save(user);

        user = new User();
        user.setUserName("keenan");
        user.setEmail("keenan@email.com");
        user.setPassword("123234");
        user.setRole(roleRepo.getByName("Manager"));
        if (userRepo.getByName(user.getUserName()) == null)
            userRepo.save(user);

        user = new User();
        user.setUserName("alfiani");
        user.setEmail("keenan@email.com");
        user.setPassword("123234");
        user.setRole(roleRepo.getByName("HR"));
        if (userRepo.getByName(user.getUserName()) == null)
            userRepo.save(user);

        user = new User();
        user.setUserName("AIM");
        user.setEmail("aim@email.com");
        user.setPassword("123234");
        user.setRole(roleRepo.getByName("User"));
        if (userRepo.getByName(user.getUserName()) == null)
            userRepo.save(user);
    }
}
