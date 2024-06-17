package com.whl.leekcode.other.design.Factory.gpt.factoryMethodDemo;

/**
 *  具体工厂A
 * @author 79183
 * @date 2024/6/14 11:31
 */
class ConcreteFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}
