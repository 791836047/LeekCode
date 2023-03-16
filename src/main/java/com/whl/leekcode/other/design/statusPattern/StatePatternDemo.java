package com.whl.leekcode.other.design.statusPattern;

/**
 *
 * @author liaowenhui
 * @date 2022/10/14 14:40
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
