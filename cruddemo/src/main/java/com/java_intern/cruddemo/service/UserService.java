package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.response.PagingResponse;
import com.java_intern.cruddemo.dto.request.UserRequest;
import com.java_intern.cruddemo.dto.request.PagingRequest;
import com.java_intern.cruddemo.dto.response.UserResponse;
import com.java_intern.cruddemo.entity.User;

public interface UserService {
    UserResponse getOne(Long id);
    PagingResponse<User> getAll(PagingRequest request);
    UserResponse createUser(UserRequest request);
    UserResponse updateUser(Long id , UserRequest request);
    String deleteUser(Long id);
}
