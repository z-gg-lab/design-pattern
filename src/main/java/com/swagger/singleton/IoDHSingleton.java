package com.swagger.singleton;

import lombok.SneakyThrows;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * 静态内部类单例（使用classLoader机制保证线程安全）
 * Initialization Demand Holder技术单例
 *
 * 从外部无法访问静态内部类HolderClass，只有当调用IoDHSingleton.getInstance方法的时候，才能得到单例对象INSTANCE
 *
 * INSTANCE对象初始化的时机并不是在单例类IoDHSingleton被加载的时候，而是在调用getInstance方法，
 * 使得静态内部类HolderClass被加载的时候。因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全
 *
 * @author 003364
 */
public class IoDHSingleton implements Serializable {

    private IoDHSingleton(){
        System.out.println("私有的构造方法被调用");
    }

    private static class HolderClass{
        private final static IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }


    public static void main(String[] args) {
        IoDHSingleton.wreckByReflect();
        IoDHSingleton.wreckByDeserialization();
    }

    /**
     * 反射方式破坏单例
     */
    @SneakyThrows
    public static void wreckByReflect(){
        //获得构造器
        Constructor con = IoDHSingleton.class.getDeclaredConstructor();
        //设置为可访问
        con.setAccessible(true);
        //构造两个不同的对象
        IoDHSingleton singleton1 = (IoDHSingleton) con.newInstance();
        IoDHSingleton singleton2 = (IoDHSingleton) con.newInstance();
        //验证是否是不同对象
        System.out.println("是否是相同的对象："+ singleton1.equals(singleton2));
    }

    /**
     * 反序列化破坏单例
     */
    public static void wreckByDeserialization(){
        IoDHSingleton instance = IoDHSingleton.getInstance();
        byte[] serialize = SerializationUtils.serialize(instance);
        IoDHSingleton newInstance = SerializationUtils.deserialize(serialize);
        System.out.println("是否是相同的对象："+ instance.equals(newInstance));
    }
}
