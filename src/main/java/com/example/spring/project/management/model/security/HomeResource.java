package com.example.spring.project.management.model.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String user() {
        return ("<h1>Welcome</h1>");
    }
    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/viewer")
    public String viewer() {
        return ("<h1>Welcome Viewer</h1>");
    }
}
