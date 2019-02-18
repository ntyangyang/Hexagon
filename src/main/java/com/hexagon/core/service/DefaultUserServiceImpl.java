package com.hexagon.core.service;

import com.google.inject.Inject;
import com.hexagon.core.domain.User;
import com.hexagon.core.exception.UserNotFoundException;
import com.hexagon.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:27
 * @description 应用层服务默认实现类
 */
@Component
public class DefaultUserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Inject
    public DefaultUserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User registerUser(User user) {
        return repo.createUser(user);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        return repo.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer userId) {
        return repo.findUserById(userId);
    }
}
