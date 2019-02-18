package com.hexagon.core.repository;

import com.hexagon.core.domain.User;
import com.hexagon.core.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:21
 * @description 存储接口
 */
@Component
public interface UserRepository {

    public User createUser(User user);

    public User updateUser(User user) throws UserNotFoundException;

    public List<User> findAll();

    public Optional<User> findUserById(Integer userId);
}
