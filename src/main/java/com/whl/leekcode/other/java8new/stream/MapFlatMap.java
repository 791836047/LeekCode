package com.whl.leekcode.other.java8new.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
 *  map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 *  flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 * @author liaowenhui
 * @date 2022/1/11 18:31
 */
public class MapFlatMap {
    public static void main(String[] args) {
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);

    }
}
