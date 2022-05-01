package com.nhnacademy.board.userdomain;

public class UserImpl implements User{
    String id;
    String pwd;
    String name;
    String profileImg;

    public UserImpl(String id, String pwd, String name, String profileImg) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.profileImg = profileImg;
    }

    public UserImpl(){}

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getProfileFileName() {
        return this.profileImg;
    }

    @Override
    public void setProfileFileName(String profileFileName) {

    }
}
