package com.swagger.singleton;

/**
 * 懒汉式单例：加锁
 * 缺点：在加锁的情况下，会是程序串行化，使系统有严重的性能问题
 * @author 003364
 */
public class LazySingleton1 {

    private static LazySingleton1 instance = null;

    private LazySingleton1() {
    }


    public synchronized static LazySingleton1 getInstance() {

        if (instance == null) {
            instance = new LazySingleton1();
        }

        return instance;
    }
}
