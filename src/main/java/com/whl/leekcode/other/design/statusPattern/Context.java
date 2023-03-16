package com.whl.leekcode.other.design.statusPattern;

/**
 * Context 是一个带有某个状态的类。
 * @author liaowenhui
 * @date 2022/10/14 14:39
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
