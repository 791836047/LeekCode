package com.whl.leekcode.other.design.chainOfResponsibilityPattern;

/**
 * @author liaowenhui
 * @date 2022/4/25 14:12
 */
public class FileLogger  extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
