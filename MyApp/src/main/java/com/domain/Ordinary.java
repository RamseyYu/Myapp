package com.domain;

import com.constant.NumberType;

import java.util.Random;

/** 普通数类（非分数） */
public class Ordinary extends Type{
    /** 实际数值 */
    private int value;

    public Ordinary() {
        this.numberType = NumberType.ORDINARY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public void getRandom(int range) {
        /** 生成数值 */
        this.value = new Random().nextInt(range) + 1;
    }
}
