package com.example.spring.project.management.model.user.controller;

import com.example.spring.project.management.model.projects.dto.CreateProjectRequest;
import com.example.spring.project.management.model.projects.dto.ProjectResponse;
import com.example.spring.project.management.model.projects.dto.UpdateProjectResponse;
import com.example.spring.project.management.model.user.dto.CreateUserRequest;
import com.example.spring.project.management.model.user.dto.UpdateUserResponse;
import com.example.spring.project.management.model.user.dto.UserResponse;
import com.example.spring.project.management.model.user.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class MyUserDetailsController {

    private final MyUserDetailsService myUserDetailsService;

    public MyUserDetailsController(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @PostMapping("/register")
    public UserResponse createUser(@RequestBody CreateUserRequest request) {
        log.info("user addition has been triggered: {}", request);
        return myUserDetailsService.createUser(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<UserResponse> getUsersList() {
        log.info("someone asked for an users list");
        return myUserDetailsService.getUsersList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        log.info("someone asked for user with id - {}", userId);
        return myUserDetailsService.getUserById(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{userId}")
    public UpdateUserResponse updateUser (@PathVariable Long userId, @RequestBody CreateUserRequest request) {
        log.info("user update with id - {} has been triggered, data: {}", userId, request);
        return myUserDetailsService.updateUser(userId, request);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public void deleteUserById(Long userId) {
        log.info("someone ask to delete user with id - {}", userId);
        myUserDetailsService.deleteUserById(userId);
    }


//        @GetMapping("/{userId}")
//        public UserResponse updateUser(@PathVariable Long userId) {
//            return myUserDetailsService.updateUser();
//        }

}
