package quanvm.com.userservice.dto.response;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import quanvm.com.userservice.pojo.Roles;
import quanvm.com.userservice.pojo.Status;
import java.time.Instant;

@Data
@RequiredArgsConstructor
public class UserResponseDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private Roles role;
    private Status status;
    private Instant createdAt;


}
