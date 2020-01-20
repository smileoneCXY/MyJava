package com.cxy.generic;

/**
 * @Author:chenxiaoyi
 * @Date:2019/7/30 19:17
 */

public class Person {
    private Integer id;
    public String name ;

    public Person() {
        System.out.println("Person.Person");
    }

    private Person(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Person.Person  Integer id, String name");
    }

    public void show(){
        System.out.println("Person.show------public");
    }

    private void hide(){
        System.out.println("Person.hide-------private");
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
