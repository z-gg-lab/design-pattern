package com.swagger.singleton;

/**
 * 饿汉式单例（线程安全）
 * 缺点：
 *  （1）不能实现懒加载，造成空间浪费，如果一个类比较大，
 *   我们在初始化的时就加载了这个类，但是我们长时间没有使用这个类，这就导致了内存空间的浪费。
 *
 * 单例模式的特点：
 *      1.私有的构造方法
 *      2.私有的静态实例
 *      3.静态的获取实例的方法
 *
 * @author 003364
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }

}
