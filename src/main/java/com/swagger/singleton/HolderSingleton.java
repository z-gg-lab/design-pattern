package com.swagger.singleton;

/**
 * Initialization Demand Holder技术单例
 *
 * @author zhuTail
 */
public class HolderSingleton {

    private HolderSingleton(){}

    private static class HolderClass{
        private final static HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        HolderSingleton s1, s2;
        s1 = HolderSingleton.getInstance();
        s2 = HolderSingleton.getInstance();
        System.out.println(s1==s2);
    }
}
