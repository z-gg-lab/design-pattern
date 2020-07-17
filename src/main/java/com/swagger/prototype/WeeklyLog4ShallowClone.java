package com.swagger.prototype;

import lombok.Data;

/**
 * 原型模式：使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 *  数据类型：
 *      值类型（基本数据类型）：int、double、byte、boolean、char等简单数据类型
 *      引用类型：接口、类、数组等复杂类型
 *  浅拷贝（ShallowClone）：当对象被复制时只复制它本身和其中包含的值类型的成员变量，而引用类型的成员对象并没有复制。实现cloneable接口
 *  深拷贝（DeepClone）：在深克隆中，除了对象本身被复制外，对象所包含的所有成员变量也将复制，实现Serializable接口
 */
@Data
public class WeeklyLog4ShallowClone implements Cloneable {

    private String name;
    private String date;
    private String content;

    public WeeklyLog4ShallowClone(){
        System.out.println("周报创建成功");
    }

    @Override
    public WeeklyLog4ShallowClone clone() {
        Object object = null;
        try {
            System.out.println("周报克隆成功");
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Not support cloneable");
        }
        return (WeeklyLog4ShallowClone) object;
    }

    public static void main(String[] args) {
        //创建原型对象
        WeeklyLog4ShallowClone logPrevious = new WeeklyLog4ShallowClone();
        logPrevious.setName("003364");
        logPrevious.setDate("2020-07-09");
        logPrevious.setContent("xxxx！");

        WeeklyLog4ShallowClone logNew = logPrevious.clone();
        logNew.setDate("2020-07-16");

        System.out.println(logPrevious == logNew);
    }

}
