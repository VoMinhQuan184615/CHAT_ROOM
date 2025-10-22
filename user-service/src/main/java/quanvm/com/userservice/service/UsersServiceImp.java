package quanvm.com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.pojo.Status;
import quanvm.com.userservice.pojo.Users;
import quanvm.com.userservice.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    UsersRepository usersRepository;
    @Override
    public Users register(UsersRegisterRequest request) {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setCreatedAt(request.getCreatedAt());

        user.setStatus(Status.ACTIVE);
        return usersRepository.save(user);
    }
}
