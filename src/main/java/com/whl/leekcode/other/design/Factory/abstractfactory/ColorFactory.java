package com.whl.leekcode.other.design.Factory.abstractfactory;

import com.whl.leekcode.other.design.Factory.Shape;

/**
 * @author 79183
 * @date 2024/6/14 10:15
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
