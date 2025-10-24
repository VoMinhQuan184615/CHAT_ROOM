package quanvm.com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import quanvm.com.userservice.dto.response.ApiResponse;
import quanvm.com.userservice.dto.response.UserResponseDTO;
import quanvm.com.userservice.pojo.Users;
import quanvm.com.userservice.service.UsersService;
import quanvm.com.userservice.utils.JwtUtils;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getProfile(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        String id = new JwtUtils().extractUserId(token);
        UserResponseDTO user = usersService.findById(UUID.fromString(id));
        if (user != null) {
            return ResponseEntity.ok(ApiResponse.<UserResponseDTO>builder()
                    .code(200)
                    .message("Success")
                    .result(user)
                    .build());
        }
        return ResponseEntity.status(403).body(
                ApiResponse.<UserResponseDTO>builder()
                        .code(403)
                        .message("Not found profile")
                        .build()
        );
    }

}
