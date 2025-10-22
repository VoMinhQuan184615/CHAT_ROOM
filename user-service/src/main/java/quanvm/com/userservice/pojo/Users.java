package quanvm.com.userservice.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue
    private UUID id;  // dùng UUID làm primary key

    @Column(nullable = false, unique = true)
    private String username;
    private String email;

    @Column(nullable = false)
    private String password;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    private Status status;

    private Instant createdAt;
}
