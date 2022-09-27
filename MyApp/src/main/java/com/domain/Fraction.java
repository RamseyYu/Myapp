package com.domain;

import com.constant.NumberType;

import java.util.Objects;
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
        this.value = (double)this.numer / this.denomin;
        this.realVal = this.value;
    }

    public String generateStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(numer).append("/").append(denomin);
        return sb.toString();
    }

    /** 判断相等 */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return  numer == fraction.numer && denomin == fraction.denomin;
    }

    public int hashCode() {
        return Objects.hash(numer, denomin);
    }
}
