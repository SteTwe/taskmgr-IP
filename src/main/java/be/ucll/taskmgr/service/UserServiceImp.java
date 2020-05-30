package be.ucll.taskmgr.service;

import be.ucll.taskmgr.model.UserRole;
import be.ucll.taskmgr.model.db.UserRepository;
import be.ucll.taskmgr.model.domain.dto.CreateUserDto;
import be.ucll.taskmgr.model.domain.dto.UserDto;
import be.ucll.taskmgr.model.domain.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        //todo create default users
    }


    @Override
    public UserDto createUser(CreateUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getUsername().endsWith("a") ? UserRole.ADMIN : UserRole.USER);
        user = repository.save(user);
        return convert(user);
    }

    private UserDto convert(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s);
        if (user == null) throw new UsernameNotFoundException("User does not exist");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }
}
