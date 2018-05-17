package com.sxt.jdkproxy;

public class UserImpl implements UserInterface {

    @Override
    public String findUser(String name) {
        System.out.println("UserImpl.findUser" + name);
        return name;
    }

    @Override
    public void addUser() {
        System.out.println("UserImpl.addUser");
    }

    @Override
    public void updateUser() {
        System.out.println("UserImpl.updateUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("UserImpl.deleteUser");
    }
}
