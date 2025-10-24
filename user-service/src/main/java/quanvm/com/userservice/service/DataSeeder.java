package quanvm.com.userservice.service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import quanvm.com.userservice.pojo.Roles;
import quanvm.com.userservice.repository.RolesRepository;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RolesRepository rolesRepository;

    public DataSeeder(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(rolesRepository.count() == 0) { // chỉ seed nếu DB trống
            Roles admin = Roles.builder()
                    .code("ADMIN")
                    .description("Administrator")
                    .build();

            Roles user = Roles.builder()
                    .code("USER")
                    .description("Regular User")
                    .build();

            Roles manager = Roles.builder()
                    .code("MANAGER")
                    .description("Manager role")
                    .build();

            rolesRepository.saveAll(List.of(admin, user, manager));

            System.out.println("Roles seeded successfully!");
        }
    }
}

