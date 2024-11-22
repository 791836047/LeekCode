package com.whl.leekcode.other;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author liaowenhui
 * @date 2024/2/27 20:02
 */
public class testtseet {

    public static void main(String[] args) {
        LocalDateTime createTime = LocalDateTime.of(2024,11,4,17,30,15);
        LocalDateTime now = LocalDateTime.now();

        System.out.println("相隔天数:" + ChronoUnit.DAYS.between(createTime, now));
    }

}
