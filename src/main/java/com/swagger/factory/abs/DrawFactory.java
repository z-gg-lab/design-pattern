package com.swagger.factory.abs;

public interface DrawFactory {

    /**
     * 获取圆形
     *
     * @return
     */
    Circle getCircle();

    /**
     * 获取矩形
     *
     * @return
     */
    Rectangle getRectangle();
}
