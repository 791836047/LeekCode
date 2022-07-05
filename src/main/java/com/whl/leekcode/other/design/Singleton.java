package com.whl.leekcode.other.design;

/**
 * 单例模式  拼多多、百度一面手写
 * @author liaowenhui
 * @date 2022/4/14 9:51
 */
public class Singleton {
    private static volatile Singleton singleton;

    /**
     * 让构造函数为 private，这样该类就不会被实例化,外部new Singleton()会报错
     */
    private Singleton() {
    }

    /**
     * 获取唯一可用的对象
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
