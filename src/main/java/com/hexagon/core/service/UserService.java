package com.hexagon.core.service;

import com.hexagon.core.domain.User;
import com.hexagon.core.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:24
 * @description 应用层服务接口
 */
@Component
public interface UserService {

    public User registerUser(User user);

    public User updateUser(User user) throws UserNotFoundException;

    public List<User> getAllUsers();

    public Optional<User> findUserById(Integer userId);
}
