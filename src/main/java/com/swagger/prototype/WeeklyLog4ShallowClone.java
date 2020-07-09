package com.swagger.prototype;

/**
 * 原型模式：使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 *  数据类型：
 *      值类型（基本数据类型）：int、double、byte、boolean、char等简单数据类型
 *      引用类型：接口、类、数组等复杂类型
 *  浅拷贝（ShallowClone）：当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制。实现cloneable接口
 *  深拷贝（DeepClone）：在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制，实现Serializable接口
 */
public class WeeklyLog4ShallowClone implements Cloneable {

    private String name;
    private String date;
    private String content;

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

    @Override
    public WeeklyLog4ShallowClone clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return (WeeklyLog4ShallowClone) object;
    }

    public static void main(String[] args) {
        //创建原型对象
        WeeklyLog4ShallowClone log_previous = new WeeklyLog4ShallowClone();
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");

        System.out.println("****周报****");
        System.out.println("周次：" +  log_previous.getDate());
        System.out.println("姓名：" +  log_previous.getName());
        System.out.println("内容：" +  log_previous.getContent());
        System.out.println("--------------------------------");

        WeeklyLog4ShallowClone log_new;
        //调用克隆方法创建克隆对象
        log_new  = log_previous.clone();
        log_new.setDate("第13周");
        System.out.println("****周报****");
        System.out.println("周次：" + log_new.getDate());
        System.out.println("姓名：" + log_new.getName());
        System.out.println("内容：" + log_new.getContent());

        System.out.println(log_previous == log_new);
        System.out.println(log_previous.getDate().equals(log_new.getDate()));
        System.out.println(log_previous.getName().equals(log_new.getName()));
        System.out.println(log_previous.getContent().equals(log_new.getContent()));
    }

}
