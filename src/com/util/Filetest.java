package com.util;

import edu.princeton.cs.algs4.StdOut;

/**
 * @description:
 * @author: Andy
 * @date: 2020/4/14 0:04
 */
public class Filetest {
    public static void main(String[] args) {
        String[] strings =
                ReadFile.readTxtByLineToString(
                        "D:\\ideaworkspace\\data\\algs4-data\\tinyBatch.txt");
        for (String s : strings) StdOut.println(s);
    }
}
