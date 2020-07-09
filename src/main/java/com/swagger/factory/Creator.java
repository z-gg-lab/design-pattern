package com.swagger.factory;

/**
 * @author 003364
 */
public interface Creator {

    /**
     * 创建一个产品对象
     *
     * @param c
     * @param <T>
     * @return
     */
    <T extends Product> T createProduct(Class<T> c);
}
