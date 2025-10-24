package quanvm.com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quanvm.com.userservice.dto.response.ApiResponse;
import quanvm.com.userservice.dto.request.UserLoginRequest;
import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.pojo.Users;
import quanvm.com.userservice.service.JWTService;
import quanvm.com.userservice.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UsersService usersService;
    @Autowired
    JWTService jwtService;
    @GetMapping("/login")
    public ApiResponse<String> login(@RequestBody UserLoginRequest request) {
        Users user = usersService.login(request);
        if (user != null) {
            return ApiResponse.<String>builder()
                    .code(200)
                    .result(jwtService.generateToken(user))
                    .message("Success")
                    .build();
        }return ApiResponse.<String>builder()
                    .code(500)
                    .message("fail")
                    .build();
    }
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody UsersRegisterRequest request){
        Users user = usersService.register(request);
        if (user != null){
            return ApiResponse.<String>builder()
                    .code(200)
                    .message("Success")
                    .build();
        }
        return ApiResponse.<String>builder()
                .code(500)
                .message("fail")
                .build();
    }
}

