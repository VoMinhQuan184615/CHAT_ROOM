package quanvm.com.userservice.mapper;

import lombok.Data;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import quanvm.com.userservice.dto.response.UserResponseDTO;
import quanvm.com.userservice.pojo.Users;



@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO toUserResponseDTO(Users user);
}
