package com.swagger.adapter;

/**
 * <strong>适配器模式：</strong>
 * <h1>1.概念：</h1>
 * <p>把一个类的接口变换成客户端所期待的另一种接口，
 * 从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。</p>
 * <h1>2.分类：</h1>
 * <p>（1）类的适配器模式
 * 类的适配器模式把适配的类的API转换成为目标类的API<br>（2）对象的适配器模式
 * 与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，与类的适配器模式不同的是，
 * 对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 * <h1>3.优点：</h1>
 * （1）更好的复用性<br>（2）更好的扩展性
 * <h1>4.缺点：</h1>
 * 过多的使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，一个系统如果太多出现这种情况，
 * 无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 * @author Tail
 *
 */
public class Adapter2{
	// 对象的适配器模式
	private Adaptee adaptee;
	
	public Adapter2(Adaptee adaptee){
		this.adaptee = adaptee;
	}
    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    public void sampleOperation1(){
        this.adaptee.sampleOperation1();
    }
    /**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
    public void sampleOperation2(){
        //写相关的代码
    }
}