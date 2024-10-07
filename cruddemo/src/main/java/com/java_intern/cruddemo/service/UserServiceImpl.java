package com.java_intern.cruddemo.service;

import com.java_intern.cruddemo.dto.response.PagingResponse;
import com.java_intern.cruddemo.dto.request.UserRequest;
import com.java_intern.cruddemo.dto.request.PagingRequest;
import com.java_intern.cruddemo.dto.response.UserResponse;
import com.java_intern.cruddemo.entity.Paging;
import com.java_intern.cruddemo.entity.User;
import com.java_intern.cruddemo.exception.GlobalExceptionHandling;
import com.java_intern.cruddemo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    private Paging<User> toPaging(PagingRequest<User> request) {
        int offset = (request.getCurrentPage() - 1) * request.getPageSize();
        request.setOffset(offset);

        List<User> users = userMapper.getAllUsers(request);
        long total = userMapper.countUsers();

        return Paging.<User>builder()
                .pageSize(request.getPageSize())
                .offset(request.getOffset())
                .currentPage(request.getCurrentPage())
                .total(total)
                .data(users)
                .build();
    }

    private PagingResponse<User> toPagingResponse(Paging<User> paging) {
        return PagingResponse.<User>builder()
                .pageSize(paging.getPageSize())
                .currentPage(paging.getCurrentPage())
                .total(paging.getTotal())
                .data(paging.getData())
                .build();
    }

    @Override
    public UserResponse getOne(Long id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            throw new GlobalExceptionHandling.NotFoundResource("User not found");
        }
        return toUserResponse(user);
    }

    @Override
    public PagingResponse<User> getAll(PagingRequest request) {
        Paging<User> paging = toPaging(request);
        return toPagingResponse(paging);
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.addUser(request);
        return toUserResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        userMapper.updateUser(id, request);
        User user = userMapper.getUserById(id); // Fetch the updated user
        return toUserResponse(user);
    }

    @Override
    public String deleteUser(Long id) {
        userMapper.deleteUser(id);
        return "User has been deleted";
    }
}
