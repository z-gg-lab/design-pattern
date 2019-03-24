package com.swagger.producerandconsumer;

import java.util.concurrent.*;

/**
 *
 * @author zhuTail
 */
public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 2000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        //新建一个阻塞队列，队列长度是5
        BlockingQueue<String> queue = new LinkedBlockingDeque<String>(5);
        Consumer consumer = new Consumer(queue);
        Producer producer = new Producer(queue);

        for (int i = 0; i < 1; i++) {
            executor.execute(producer);
        }

        for (int i = 0; i < 1; i++) {
            executor.execute(consumer);
        }
    }
}