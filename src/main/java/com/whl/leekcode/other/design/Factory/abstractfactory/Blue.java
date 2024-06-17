package com.whl.leekcode.other.design.Factory.abstractfactory;

/**
 * @author 79183
 * @date 2024/6/14 10:13
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
