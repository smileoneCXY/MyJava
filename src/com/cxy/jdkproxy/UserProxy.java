package com.cxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserProxy implements InvocationHandler {
    private  Object target;

    public UserProxy(Object target) {
        this.target = target;
    }
    /**
     *
     * @param proxy 代理对象，包含了代理对象所有的内容
     * @param method 调用者 使用的当前方法
     * @param args  调用某个方法传入的参数
     * @return 调用者调用某个方法的 返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke =null;
            boolean b = method.getName().matches("^add.*");
            if(b){
                System.out.println("add方法被调用前做处理");
                invoke = method.invoke(target,args);
                System.out.println("add方法被调用后做处理");
            }else{
                invoke = method.invoke(target, args);
                System.out.println("invoke = " + invoke);
            }
        return null;
    }
}
