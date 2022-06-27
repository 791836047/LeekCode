package com.whl.leekcode.other.design;

/**
 * @author liaowenhui
 * @date 2022/4/14 9:51
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){ };

    public static Singleton getSingleton(){
        if (null == singleton){
            synchronized (Singleton.class){
                if (singleton == null) {
                     singleton = new Singleton();
                }
            }
        }
        return singleton;
    }



}
