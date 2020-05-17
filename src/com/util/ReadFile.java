package com.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @date: 2020/4/13 23:44
 */
public class ReadFile {

    // 以行为单位读取文件
    public static Integer[] readTxtByLine(String path) {
        List<Integer> readResultList = new ArrayList<>();
        Integer[] readResult = new Integer[] {};
        // 获取文件对象
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int n = 0;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split(" ");
                for (int i = 0; i < s.length; i++) {
                    readResultList.add(Integer.parseInt(s[i]));
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readResultList.toArray(readResult);
    }

    // 以行为单位读取文件
    public static String[] readTxtByLineToString(String path) {
        List<String> readResultList = new ArrayList<>();
        String[] readResult = new String[] {};
        // 获取文件对象
        File file = new File(path);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int n = 0;
            while ((line = reader.readLine()) != null) {
                readResultList.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readResultList.toArray(readResult);
    }
}
