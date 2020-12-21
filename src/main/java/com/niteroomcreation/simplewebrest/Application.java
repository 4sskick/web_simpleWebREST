package com.niteroomcreation.simplewebrest;

import com.niteroomcreation.simplewebrest.models.data.domains.Role;
import com.niteroomcreation.simplewebrest.models.data.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepo;

//	@Autowired
//	private UserService userServe;

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
//		User user = new User();
//		user.setUserName("monta");
//		user.setEmail("monta@email.com");
//		user.setPassword("123qwe");
//		user.setRole(roleServe.getById());
    }
}
