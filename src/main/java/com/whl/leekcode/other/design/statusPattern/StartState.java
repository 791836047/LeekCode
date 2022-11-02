package com.whl.leekcode.other.design.statusPattern;/**
 * @author liaowenhui
 * @date 2022/10/14 14:39
 */

/**
 *
 * @author liaowenhui
 * @date 2022/10/14 14:39
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Start State";
    }
}
