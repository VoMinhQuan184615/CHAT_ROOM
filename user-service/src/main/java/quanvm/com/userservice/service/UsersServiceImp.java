package quanvm.com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanvm.com.userservice.dto.request.UserLoginRequest;
import quanvm.com.userservice.dto.request.UsersRegisterRequest;
import quanvm.com.userservice.dto.response.UserResponseDTO;
import quanvm.com.userservice.mapper.UserMapper;
import quanvm.com.userservice.pojo.Status;
import quanvm.com.userservice.pojo.Users;
import quanvm.com.userservice.repository.RolesRepository;
import quanvm.com.userservice.repository.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Service
public class UsersServiceImp implements UsersService{
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    UserMapper userMapper;




    @Override
    public Users register(UsersRegisterRequest request) {
        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        String passwordHash = passwordEncoder.encode(request.getPassword());
        user.setPassword(passwordHash);
        user.setFullName(request.getFullName());
        user.setCreatedAt(java.time.Instant.now());
        user.setRole(rolesRepository.findById(2L).orElse(null));
        user.setStatus(Status.ACTIVE);
        return usersRepository.save(user);
    }
    @Override
    public Users login(UserLoginRequest request) {
        Users user = usersRepository.findUsersByUsername(request.getUsername());
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return user;
        }
        return null;
    }
    @Override
    public UserResponseDTO findById(UUID id) {
        return userMapper.toUserResponseDTO(usersRepository.findById(id).orElse(null));
    }
}
