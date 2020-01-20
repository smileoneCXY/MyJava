package com.cxy.java8.functional;


import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author : chenxiaoyi
 * @Date: 2020/1/20 9:24
 */
public class MyFunctionalImpl  {

    public static void main(String[] args) {
        /*函数式接口基本使用 判断类型机制*/
        MyFunctional<String,Integer> myFunctional = Integer::valueOf;
        System.out.println(myFunctional.conver("123")+ myFunctional.defaultFunc());

        /*函数式接口引用构造器**/
        PersonFactory<Person> personFactory = Person::new;
        Person cxy = personFactory.create("cxy", 23);
        System.out.println(cxy.toString());
        //***********************************

        /*断言 用于判断 boolean (T param)*/
        Predicate<String> predicate = (c) -> c.length()>0;
        System.out.println(predicate.test("123")); //true
        System.out.println(predicate.negate().test("123")); //false

        /*方法 用于加工 T (F param)*/
        Function<String,Integer> function = Integer::valueOf;
        Function<String, String> andThen = function.andThen(String::valueOf);
        System.out.println(andThen.apply("233")); //123

        /*生产 用于创建 T ()*/
        Supplier<Person> supplier = Person::new;
        System.out.println(supplier.get().toString()); //Person.toString()

        /*用于消费 void (T param)*/
        Consumer<Person> consumer = (p) ->  System.out.println(p.getName());
        consumer.accept(new Person("cxy",23));

        timeConsole(()->{
            timeConsole(() -> func1("a"), "func1");
            timeConsole(() -> func2("b"), "func2");
        },"func1+func2");

    }

    /**
     * 测试耗时
     */
     private static <T>  T timeConsole(Supplier<T> sup, String desc){
        long startTime = System.currentTimeMillis();
        T t = sup.get();
        System.out.println( desc +"耗时:\t"+(System.currentTimeMillis() - startTime));
        return t;
    }

     private static void  timeConsole(DefFunction fun, String desc){
        long startTime = System.currentTimeMillis();
        fun.test();
        System.out.println( desc +"耗时:\t"+(System.currentTimeMillis() - startTime));
    }

    private static String func1(String param){
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        return param;
    }

    private static String func2(String param){
        try { TimeUnit.SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        return param;
    }

}
