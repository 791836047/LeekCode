package com.whl.leekcode.other.design.decoratorPattern;

/**
 *  装饰器模式
 * @author liaowenhui
 * @date 2023/4/6 10:21
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
