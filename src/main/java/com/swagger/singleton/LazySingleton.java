package com.swagger.singleton;

/**
 * 懒汉式单例：双重判断
 *
 * @author 003364
 */
public class LazySingleton {

    /**
     * volatile 防止指令重排
     */
    private volatile static LazySingleton instance = null;

    private LazySingleton(){
        /**
         * 如果构造函数中操作比较多时，为了提升效率，JVM 会在构造函数里面的属性未全部完成实例化时，就返回对象。
         * 双重检测锁出现空指针问题的原因就是出现在这里，当某个线程获取锁进行实例化时，
         * 其他线程就直接获取实例使用，由于JVM指令重排序的原因，其他线程获取的对象也许不是一个完整的对象，所以在使用实例的时候就会出现空指针异常问题
         */
    }

    public static LazySingleton getInstance() {

        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class){
                //第二重判断
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
