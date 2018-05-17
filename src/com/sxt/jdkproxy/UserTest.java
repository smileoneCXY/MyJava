package com.sxt.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UserTest {
    public static void main(String[] args) {
        UserInterface user = new UserImpl();

        InvocationHandler handler = new UserProxy(user);

        UserInterface proxyInstance = (UserInterface) Proxy
                .newProxyInstance(handler.getClass().getClassLoader(), user.getClass().getInterfaces(), handler);
        proxyInstance.findUser("cxy");
       // proxyInstance.addUser();
    }
}
