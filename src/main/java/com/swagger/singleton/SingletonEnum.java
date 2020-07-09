package com.swagger.singleton;

import lombok.SneakyThrows;
import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.Constructor;

/**
 * 虚拟机会保证线程安全
 *
 * @author 003364
 */

public enum SingletonEnum {

    /**
     *
     */
    INSTANCE;

    /**
     * 干活
     */
    public void handle() {
        System.out.println("go go go");
    }

    public static void main(String[] args) {
//        SingletonEnum.wreckByReflect();
        SingletonEnum.wreckByDeserialization();
    }

    /**
     * 打破单例
     */
    @SneakyThrows
    public static void wreckByReflect(){
        //获得构造器
        Constructor con = SingletonEnum.class.getDeclaredConstructor();
        //设置为可访问
        con.setAccessible(true);
        //构造两个不同的对象
        SingletonEnum singleton1 = (SingletonEnum) con.newInstance();
        SingletonEnum singleton2 = (SingletonEnum) con.newInstance();
        //验证是否是不同对象
        System.out.println("是否是相同的对象："+ singleton1.equals(singleton2));
    }

    public static void wreckByDeserialization(){
        SingletonEnum instance = SingletonEnum.INSTANCE;
        byte[] serialize = SerializationUtils.serialize(instance);
        SingletonEnum newInstance = SerializationUtils.deserialize(serialize);
        System.out.println("是否是相同的对象："+ instance.equals(newInstance));
    }
}
