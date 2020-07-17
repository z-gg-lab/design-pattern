package com.swagger.prototype;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeeklyLog implements Cloneable{

    private String name;

    private List<String> addressee = new ArrayList<String>();

    public static void main(String[] args) throws CloneNotSupportedException {
        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.getAddressee().add("1@qq.com");
        WeeklyLog clone = (WeeklyLog)weeklyLog.clone();
        clone.getAddressee().add("2@qq.com");
        System.out.println(weeklyLog.getAddressee().toString());
    }
}
