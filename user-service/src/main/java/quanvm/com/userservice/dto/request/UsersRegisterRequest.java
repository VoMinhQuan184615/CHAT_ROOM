package quanvm.com.userservice.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quanvm.com.userservice.pojo.Roles;
import quanvm.com.userservice.pojo.Status;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersRegisterRequest {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Instant createdAt;
}
