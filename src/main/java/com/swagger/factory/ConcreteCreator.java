package com.swagger.factory;

import lombok.extern.java.Log;

/**
 * @author 003364
 */
@Log
public class ConcreteCreator implements Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = c.newInstance();
        } catch (Exception e) {
            log.warning("xxx");
        }
        return (T) product;
    }
}
