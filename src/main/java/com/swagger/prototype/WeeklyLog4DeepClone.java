package com.swagger.prototype;

import java.io.*;

/**
 * 原型模式：使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 * 数据类型：
 * 值类型（基本数据类型）：int、double、byte、boolean、char等简单数据类型
 * 引用类型：接口、类、数组等复杂类型
 * 浅拷贝（ShallowClone）：当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制。实现cloneable接口
 * 深拷贝（DeepClone）：在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制，实现Serializable接口
 *
 * <p>Java语言提供的Cloneable接口和Serializable接口的代码非常简单，
 * 它们都是空接口，这种空接口也称为标识接口，标识接口中没有任何方法的定义，
 * 其作用是告诉JRE这些接口的实现类是否具有某个功能，如是否支持克隆、是否支持序列化等</p>
 */
public class WeeklyLog4DeepClone implements Serializable {

    private String name;
    private String date;
    private String content;
    private Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    static class Attachment implements Serializable {
        private String name; //附件名

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void download() {
            System.out.println("下载附件，文件名为" + name);
        }
    }

    /**
     * 深拷贝
     *
     * @return WeeklyLog4DeepClone
     */
    public WeeklyLog4DeepClone deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog4DeepClone) ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建原型对象
        WeeklyLog4DeepClone log_previous = new WeeklyLog4DeepClone();
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");
        Attachment attachment = new Attachment();
        log_previous.setAttachment(attachment);
        //调用克隆方法创建克隆对象
        WeeklyLog4DeepClone log_new = log_previous.deepClone();

        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }

}
