package com.swagger.test.asm1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimesRecord {

    private static LocalDateTime now = LocalDateTime.now();

    public static void before() {
        System.out.println("请求开始的时间是 ..." + LocalDateTime.now());
    }

    public static void after() {
        System.out.println("请求结束的时间是 ..." + LocalDateTime.now());
        System.out.println("请求耗时 ..." + ChronoUnit.MILLIS.between(now, LocalDateTime.now()));
    }
}
