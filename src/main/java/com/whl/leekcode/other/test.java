package com.whl.leekcode.other;

import lombok.var;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liaowenhui
 * @date 2022/5/19 14:39
 */
public class test {
    public static void main(String[] args) {
     /*int a = 83318096;
        boolean odd = isOdd(83318097);
        int odd2 = isOdd2(a);
        System.out.println(odd2);*/

        BigDecimal a = new BigDecimal(100);
        BigDecimal b = new BigDecimal(100);
        BigDecimal c = new BigDecimal(5);


        if (a.compareTo(b) >= 0){
            BigDecimal subtract = a.subtract(c);
            System.out.println("true" + subtract);
        }else {
            System.out.println("false");
        }

    }


    public static boolean isOdd(int a){
        if((a&1) != 1){
            //是偶数
            return true;
        }
        //奇数
        return false;
    }

    public static int isOdd2(int a){
        return a % 10;
    }
}
