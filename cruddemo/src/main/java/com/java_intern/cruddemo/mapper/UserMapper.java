package com.java_intern.cruddemo.mapper;

import com.java_intern.cruddemo.dto.request.UserRequest;
import com.java_intern.cruddemo.dto.request.PagingRequest;
import com.java_intern.cruddemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserById(Long id);
    List<User> getAllUsers(@Param("getPaging") PagingRequest<User> request);
    long countUsers();
    User addUser(UserRequest request);
    User updateUser(@Param("id") Long id, @Param("request") UserRequest request);
    void deleteUser(Long id);
}
