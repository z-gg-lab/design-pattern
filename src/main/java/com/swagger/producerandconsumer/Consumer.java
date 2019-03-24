package com.swagger.producerandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhuTail
 */
public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    volatile int i = 0;


    public Consumer(BlockingQueue<String> queue) {
        //使用有参构造函数的目的是我在创建这个消费者对象的时候就可以传进来一个队列
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("消费者");
        Random random = new Random();
        try {
            while (true) {
                Thread.sleep(random.nextInt(10));
                System.out.println(Thread.currentThread().getName() + "准备消费...");
                //从队列中取任务消费，如果队列为空，会阻塞当前线程
                String temp = queue.take();
                System.out.println(Thread.currentThread().getName() + "获取到工作任务==== "+ (i++)+" --->" + temp);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
