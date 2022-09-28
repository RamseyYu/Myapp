package com.bin;/*
 * @author : bin
 * @description : 整数以及分数的四则运算
 */

import com.sun.corba.se.spi.orb.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOperate {
    public static int x = 0;  //通用分子
    public static int y = 0;  //通用分母
    public static int oneX = 0;  //one分子
    public static int oneY = 0;  //one分母
    public static int twoX = 0;  //two分子
    public static int twoY = 0;  //two分母


    //两个数相加
    public static String add(String one, String two) {
        getOneAndTwoXY(one, two);
        x = oneX * twoY + oneY * twoX;
        y = oneY * twoY;
        return simplify(x, y);
    }


    //两个数相减
    public static String subtract(String one, String two) {
        getOneAndTwoXY(one, two);
        x = oneX * twoY - oneY * twoX;
        if (x < 0) {
            return null; //如果分子出现负数返回null
        }
        y = oneY * twoY;
        return simplify(x, y);
    }

    public static String multiply(String one, String two) {
        getOneAndTwoXY(one, two);
        x = oneX * twoX;
        y = oneY * twoY;
        return simplify(x, y);
    }

    public static String divide(String one, String two) {
        getOneAndTwoXY(one, two);
        x = oneX * twoY;
        y = oneY * twoX;
        return simplify(x, y);
    }

    //提取两个数据的分子和分母到类变量中
    public static void getOneAndTwoXY(String one, String two) {
        getXY(one);
        oneX = x;
        oneY = y;
        getXY(two);
        twoX = x;
        twoY = y;
    }

    //提取数据的分子和分母到类变量中
    public static void getXY(String number) {
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
            if (index >= n) {
                y = 1;
            }
            // 读取分母
            while (index < n && Character.isDigit(number.charAt(index))) {//读取数据分母大小
                y = y * 10 + number.charAt(index) - '0';
                index++;
            }
        }
    }

    //化简分数
    public static String simplify(int a, int b) {
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (a == 0) {
            return "0";
        } else if (b == 1) {
            return "" + a;
        } else {
            return a + "/" + b;
        }
    }

    //计算分子分母最大公约数
    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {//如果有一个为0则返回1
            return 1;
        }
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }



    //把中缀表达式转化为后缀表达式集合
    public static List<String> infixExpToSuffixExp(String s) {
        List<String> infixExp = getListString(s);
        //创建一个用来存储运算符的stack
        Stack<String> operStack = new Stack<>();
        //创建一个用来临时存储计算结果的operList
        List<String> resList = new ArrayList<>();
        //遍历infixExp
        for (String item : infixExp) {
            //如果是一个数，加入resList
            // 匹配正数，负数，小数的正则表达式: ^(\-|\+)?\d+(\.\d+)?$
            if (isNumber(item)) {
                resList.add(item);
            } else if (item.equals("(")) {
                operStack.push(item);
            } else if (item.equals(")")) {
                //如果是又括号，则依次弹出operStack中的运算符，并压入resList，直到遇到左括号为止，此时将这对括号丢弃
                while (!operStack.peek().equals("(")) {
                    resList.add(operStack.pop());
                }
                operStack.pop(); //消除左括号！！！
            } else {
                //当item的优先级小于等于栈顶的优先级时
                while (operStack.size() != 0 &&
                        priority(item.charAt(0)) <= priority(operStack.peek().charAt(0))) {
                    resList.add(operStack.pop());
                }
                //还要将item压入栈
                operStack.push(item);
            }
        }
        ///将operStack中剩余的运算符依次加入resList中
        while (operStack.size() != 0) {
            resList.add(operStack.pop());
        }
        return resList;
    }

    //判断字符串是不是数据
    public static boolean isNumber(String s) {
        if (!s.equals("×") && !s.equals("÷") && !s.equals("(") && !s.equals(")") && !s.equals("+") && !s.equals("-")) {
            return true;
        }
        return false;
    }

    //返回运算符的优先级，用数字表示
    public static int priority(int oper) {
        if (oper == '×' || oper == '÷')
            return 1;
        if (oper == '+' || oper == '-')
            return 0;
        return -1;
    }


    //把字符串切分为list集合
    public static List<String> getListString(String infixExpression) {
        // 将suffixExpression按照空格分割
        String[] split = infixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

}
