package com.whl.leekcode.other.design.decoratorPattern;

/**
 *
 * @author liaowenhui
 * @date 2023/4/6 10:22
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
