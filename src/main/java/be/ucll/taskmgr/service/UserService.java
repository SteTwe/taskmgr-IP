package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.domain.dto.CreateUserDto;
import be.ucll.taskmgr.model.domain.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(CreateUserDto userDto);
}
