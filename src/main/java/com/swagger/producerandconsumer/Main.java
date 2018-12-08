package com.swagger.producerandconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zhuTail
 */
public class Main {
    public static void main(String[] args) {
        //新建一个阻塞队列，队列长度是5
        BlockingQueue<String> queue = new LinkedBlockingDeque<String>(5);
//        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(5);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        for (int i = 0; i < 3; i++) {
            new Thread(producer, "producer" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(consumer, "consumer").start();
        }
    }
}