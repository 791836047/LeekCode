package com.whl.leekcode.other.design.Factory.gpt.factoryMethodDemo;

/**
 * 具体产品A
 * @author 79183
 * @date 2024/6/14 11:24
 */
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using ConcreteProductA");
    }
}
