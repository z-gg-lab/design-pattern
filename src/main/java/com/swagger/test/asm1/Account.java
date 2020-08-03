package com.swagger.test.asm1;

public class Account {

    public void operation() throws InterruptedException {
        System.out.println("operation...");
        Thread.sleep(3000);
    }

    public void go() {
        System.out.println("go...");
    }
}
