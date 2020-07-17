package com.swagger.prototype;

import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class WeeklyLog1 implements Cloneable,Serializable{

    private String name;

    private final List<String> addressee = new ArrayList<String>();

    @SneakyThrows
    @Override
    protected WeeklyLog1 clone() {
        return this.deepClone();
    }

    /**
     * 深拷贝
     *
     * @return WeeklyLog4DeepClone
     */
    public WeeklyLog1 deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog1) ois.readObject();
    }

    public static void main(String[] args) {
        WeeklyLog1 weeklyLog = new WeeklyLog1();
        weeklyLog.getAddressee().add("1@qq.com");
        WeeklyLog1 clone = weeklyLog.clone();
        clone.getAddressee().add("2@qq.com");
        System.out.println(weeklyLog.getAddressee().toString());
    }
}
