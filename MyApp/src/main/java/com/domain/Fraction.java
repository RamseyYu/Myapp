package com.domain;

import com.constant.NumberType;

import java.util.Random;

/** 分数类 */
public class Fraction extends Type {

    /** 分子，其值要小于分母*/
    private int numer;

    /** 分母，其数值不可为0 */
    private int denomin;

    /** 实际数值 */
    private double value;

    public Fraction() {
        this.numberType = NumberType.FRACTION;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getDenomin() {
        return denomin;
    }

    public void setDenomin(int denomin) {
        this.denomin = denomin;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /** 获取随机数 */
    @Override
    public void getRandom(int range) {
        Random random = new Random();
        /** 随机产生分子，其值不可等于range */
        this.numer = random.nextInt(range - 1) + 1;
        /** 产生一个temp随机数， */
        int temp = random.nextInt(range) + 1;

        /** 判断该随机数是否符合做分母的条件，若不符合，重新生成随机数 */
        while (temp <= 0 || temp <= this.numer) {
            temp = random.nextInt(range) + 1;
        }
        /** 为分母赋值 */
        this.denomin =  temp;

    }
}
