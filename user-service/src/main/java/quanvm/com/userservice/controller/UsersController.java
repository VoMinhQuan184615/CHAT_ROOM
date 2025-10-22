package quanvm.com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quanvm.com.userservice.dto.reponse.ApiResponse;
import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.pojo.Users;
import quanvm.com.userservice.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class  UsersController {
    @Autowired
    UsersService usersService;
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
