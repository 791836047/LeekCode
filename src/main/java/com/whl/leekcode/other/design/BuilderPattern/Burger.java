package com.whl.leekcode.other.design.BuilderPattern;

/**
 * @author liaowenhui
 * @date 2023/10/30 16:06
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
