package com.nhnacademy.board.userdomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private Map<String,User> userRepository = new HashMap<>();

    @Override
    public void add(User user) {
        userRepository.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {

    }

    @Override
    public User remove(String id) {
        return null;
    }

    @Override
    public User getUser(String id) {
        return userRepository.get(id);
    }

    public List<User> getUsers() {
        return new ArrayList<>(userRepository.values());

    }
}
