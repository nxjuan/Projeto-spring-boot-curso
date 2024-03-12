package com.example.curso.resources;

import com.example.curso.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<Users> findAll(){
        Users u = new Users(1L, "Juan", "juannogueira@gmail.com", "27 9940-0289", "abcd");
        return ResponseEntity.ok().body(u);
    }
}
