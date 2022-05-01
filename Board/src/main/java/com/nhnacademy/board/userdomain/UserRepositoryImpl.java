package com.nhnacademy.board.userdomain;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private Map<String,User> userRepositoryMap = new HashMap<>();

    @Override
    public void add(User user) {
        userRepositoryMap.put(user.getId(), user);
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
        return userRepositoryMap.get(id);
    }

    @Override
    public Map<String, User> getUsers() {
        return userRepositoryMap;
    }
}
