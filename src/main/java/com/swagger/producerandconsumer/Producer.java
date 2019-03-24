package com.swagger.producerandconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhuTail
 */
public class Producer implements Runnable {

    BlockingQueue<String> blockingQueue;

    volatile int i = 0;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        Thread.currentThread().setName("生产者");
        try {
            while (true) {
                String data = Thread.currentThread().getName() + "开始生产 ---> " + i++;
                System.out.println(data);
                //向队列中放数据，如果队列是满的话，会阻塞当前线程
                blockingQueue.put(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
