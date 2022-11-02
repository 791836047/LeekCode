package com.whl.leekcode.other.design.statusPattern;/**
 * @author liaowenhui
 * @date 2022/10/14 14:39
 */

/**
 *
 * @author liaowenhui
 * @date 2022/10/14 14:39
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Stop State";
    }
}
