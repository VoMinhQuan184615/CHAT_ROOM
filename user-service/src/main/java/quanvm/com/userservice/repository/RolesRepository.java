package quanvm.com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quanvm.com.userservice.pojo.Roles;

import java.util.UUID;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
