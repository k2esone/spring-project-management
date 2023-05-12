package com.example.spring.project.management.model.user.service;

import com.example.spring.project.management.model.user.dto.CreateUserRequest;
import com.example.spring.project.management.model.user.dto.UpdateUserResponse;
import com.example.spring.project.management.model.user.dto.UserResponse;
import com.example.spring.project.management.model.user.models.MyUserDetails;
import com.example.spring.project.management.model.user.models.User;
import com.example.spring.project.management.model.user.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    private UserResponse mapUserToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.isActive(),
                user.getRoles()
        );
    }

    public UserResponse createUser(CreateUserRequest request) {
        Optional<User> users = userRepository.findByUserName(request.getUserNameR());
        if (users.isPresent()) {
            return null;
        }
        User user = User.builder()
                .userName(request.getUserNameR())
                .password(request.getPasswordR())
                .email(request.getEmailR())
                .build();

        userRepository.save(user);

        return mapUserToUserResponse(user);
    }

    public List<UserResponse> getUsersList() {
        return userRepository.findAll()
                .stream().map(user -> mapUserToUserResponse(user))
                .toList();
    }

    public UserResponse getUserById(Long userId) {
        return userRepository.findById(userId)
                .stream().map(user -> mapUserToUserResponse(user))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("User not found, id: " + userId));
    }

    private UpdateUserResponse userToUserResponse(User user) {
        return new UpdateUserResponse(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.isActive(),
                user.getRoles()
        );
    }

    public UpdateUserResponse updateUser(Long userId, CreateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found, id: " + userId));
        user.setUserName(request.getUserNameR());
        user.setPassword(request.getPasswordR());
        user.setEmail(request.getEmailR());
        user.setActive(request.isActiveR());
        user.setRoles(request.getRolesR());

        user = userRepository.save(user);

        return userToUserResponse(user);
    }

    public void deleteUserById(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("User not found, id: " + userId);
        }
    }

    //Just for tests
//    public UserResponse updateUser(Long userId) {
//        User user = userRepository.getById(userId);
//        user.setActive(true);
//        user.setRoles("ROLE_ADMIN");
//        userRepository.save(user);
//
//        return mapUserToUserResponse(user);
//}
}
