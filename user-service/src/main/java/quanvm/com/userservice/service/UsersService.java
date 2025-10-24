package quanvm.com.userservice.service;


import quanvm.com.userservice.dto.request.UserLoginRequest;
import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.dto.response.UserResponseDTO;
import quanvm.com.userservice.pojo.Users;

import java.util.UUID;

public interface UsersService {
    Users register(UsersRegisterRequest request);

    Users login(UserLoginRequest request);


    UserResponseDTO findById(UUID id);
}
