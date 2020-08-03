package com.swagger.test.Instrument;

import com.swagger.test.asm.Base;

import java.lang.management.ManagementFactory;

/**
 * 在JVM运行中的时候，将Base类的process()方法做替换
 */

public class Test {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        // 打印当前 Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            new Base().process();
        }
    }
}
