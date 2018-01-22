package com.swagger.singleton;

/**
 * 饿汉式单例
 *
 * 单例模式的特点：
 *      1.私有的构造方法
 *      2.私有的静态实例
 *      3.静态的获取实例的方法
 *
 * @author zhuTail
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return instance;
    }


}
