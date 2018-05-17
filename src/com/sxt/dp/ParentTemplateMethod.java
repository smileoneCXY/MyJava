package com.sxt.dp;

public abstract class ParentTemplateMethod {
    public void start() {
        System.out.println("ParentTemplateMethod.start");
    }

    public abstract void mid();

    public void end() {
        System.out.println("ParentTemplateMethod.end");
    }

    //定义一个模板
    public final void templte() {
        this.start();
        this.mid();
        this.end();
    }

}
