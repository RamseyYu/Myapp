package com.bin;/*
 * @author : bin
 * @description : 整数以及分数的四则运算
 */

public class NumberOperate {
    public static int x = 0;  //分子
    public static int y = 0;  //分母


    //两个数相加
    public static String add(String one, String two) {
        getXY(one);
        int oneX = x;
        int oneY = y;
        getXY(two);
        int twoX = x;
        int twoY = y;
        x = oneX*twoY + oneY*twoX;
        y = oneY * twoY;
        return simplify(x,y);
    }

    //两个数相减
    public static String subtract(String one, String two) {
        getXY(one);
        int oneX = x;
        int oneY = y;
        getXY(two);
        int twoX = x;
        int twoY = y;
        x = oneX*twoY - oneY*twoX;
        if (x<0){
            return null; //如果分子出现负数返回null
        }
        y = oneY * twoY;
        return simplify(x,y);
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
            if(index >= n){
                y=1;
            }
            // 读取分母
            while (index < n && Character.isDigit(number.charAt(index))) {//读取数据分母大小
                y = y * 10 + number.charAt(index) - '0';
                index++;
            }
        }
    }

    //化简分数
    public static String  simplify(int a,int b){
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (b == 1){
            return  ""+a;
        }else {
            return a+"/"+b;
        }
    }

    //计算分子分母最大公约数
    public static int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
