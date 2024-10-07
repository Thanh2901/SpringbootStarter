package com.java_intern.cruddemo.controller;

import com.java_intern.cruddemo.dto.response.PagingResponse;
import com.java_intern.cruddemo.dto.request.UserRequest;
import com.java_intern.cruddemo.dto.request.PagingRequest;
import com.java_intern.cruddemo.dto.response.UserResponse;
import com.java_intern.cruddemo.entity.User;
import com.java_intern.cruddemo.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.PackagePrivate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
@PackagePrivate
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }
    @PostMapping("/paging")
    public ResponseEntity<PagingResponse<User>> getAll(@RequestBody PagingRequest<User> paging) {
        PagingResponse<User> response = userService.getAll(paging);
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest request, @PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.updateUser(id, request), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
