package com.swagger.productandconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhuTail
 */
public class Producer implements Runnable {

    BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "开始生产...");
            String temp = Thread.currentThread().getName() + "：生产线程";
            //向队列中放数据，如果队列是满的话，会阻塞当前线程
            blockingQueue.put(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
