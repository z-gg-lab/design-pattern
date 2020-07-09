package com.swagger.singleton;

/**
 * 懒汉式单例：双重判断
 *
 * @author zhuTail
 */
public class LazySingleton {

    /**
     * volatile 防止指令重排
     */
    private volatile static LazySingleton instance = null;

    private LazySingleton(){}

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
