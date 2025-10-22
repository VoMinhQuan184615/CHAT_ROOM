package quanvm.com.userservice.service;


import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.pojo.Users;

public interface UsersService {
   // Users register();

    Users register(UsersRegisterRequest request);
}
