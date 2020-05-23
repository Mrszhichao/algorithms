package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 数组转换成list
 * @author: Andy
 * @date: 2020/4/4 18:13
 */
public class Demo {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        String[] strings = {"1", "2"};
        List as = Arrays.asList(a);
        // 会报异常，因为它实现的的类型是java.util.Arrays，它的内部没有实现相关方法
        // as.add(11);
        // 用java8的stream操作
        List<Integer> collect = Arrays.stream(a).boxed().collect(Collectors.toList());
        // 将不可变类转换成list
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, strings);

    }
}
