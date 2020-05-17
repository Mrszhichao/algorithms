package com.test;

/**
 * @description: 章节练习
 * @author: Andy
 * @date: 2020/4/4 23:45
 */
public class Exercises {
    public static void main(String[] args) {
        // 1.1.1 将一个数表现成二进制的数字，并以字符串的形式表现出来
        // 思路 ： 整数求解二进制的方法就是用整数除以二并再以商做除数再除以二直到除尽为止
        // 最后把每次取得的余数倒序排列起来即为该整数的二进制数
        int a = 8;
        String b = "";
        for (int i = a; i > 0; i /= 2) {
            b = i % 2 + b;
        }
        System.out.println(b);
    }
}
