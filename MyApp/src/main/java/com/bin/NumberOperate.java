package com.bin;/*
 * @author : bin
 * @description : 整数以及分数的四则运算
 */

public class NumberOperate {
    static int x = 0;  //分子
    static int y = 0;  //分母

    public static void main(String[] args) {
        getXY("12/34");
        System.out.println(x);
        System.out.println(y);
    }

    //两个数相加
    public static String add(String one, String two) {
        return null;
    }

    //提取数据的分子和分母
    public static void getXY(String number){
        //恢复xy的初始值
        x = 0;
        y = 0;

        int index = 0;
        int n = number.length();
        while (index < n) {//读取分子大小
            while (index < n && Character.isDigit(number.charAt(index))) {
                x = x * 10 + number.charAt(index) - '0';
                index++;
            }
            index++;  //跳过符号/的索引位置,进入分母的索引
            if(index == n){
                y=1;
            }
            // 读取分母
            while (index < n && Character.isDigit(number.charAt(index))) {//读取数据分母大小
                y = y * 10 + number.charAt(index) - '0';
                index++;
            }
        }
    }

}
