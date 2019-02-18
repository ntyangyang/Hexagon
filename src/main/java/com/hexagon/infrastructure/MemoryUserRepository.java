package com.hexagon.infrastructure;

import com.hexagon.core.domain.User;
import com.hexagon.core.exception.UserNotFoundException;
import com.hexagon.core.repository.UserRepository;
import com.hexagon.infrastructure.utils.IdUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:36
 * @description 内存存储设施 实现存储接口
 */
public class MemoryUserRepository implements UserRepository {
    Map<Integer, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User createUser(User user) {
        user.setId(IdUtils.getPrimaryKey());
        this.userMap.putIfAbsent(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        if (!this.userMap.containsKey(user.getId())) {
            throw new UserNotFoundException("User " + user.getId() + " can't be found");
        }
        this.userMap.putIfAbsent(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>(this.userMap.values());
        return userList;
    }

    @Override
    public Optional<User> findUserById(Integer userId) {
        Optional<User> opt = Optional.empty();

        if (this.userMap.containsKey(userId)) {
            opt = Optional.of(this.userMap.get(userId));
        }
        return opt;
    }
}
