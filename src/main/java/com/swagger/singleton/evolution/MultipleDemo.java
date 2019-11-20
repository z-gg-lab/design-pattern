package com.swagger.singleton.evolution;

/**
 * 3例模式
 *
 * @author zhuTail
 */
public class MultipleDemo {

    private MultipleDemo(){}

    private static volatile Integer count = 0;

    private static MultipleDemo multipleDemo;
    /**
     * 实例个数
     */
    public static final Integer CLASS_LIMIT = 3;

    public static MultipleDemo getInstance(){
        if (count < CLASS_LIMIT){
            synchronized (MultipleDemo.class){
                if (count < CLASS_LIMIT) {
                    count ++;
                    multipleDemo = new MultipleDemo();
                }
            }
        }
        return multipleDemo;
    }

    public static void main(String[] args) {
        for (int i = 0; i < CLASS_LIMIT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MultipleDemo instance = MultipleDemo.getInstance();
                    System.out.println(instance);
                }
            }).start();

        }
    }
}
