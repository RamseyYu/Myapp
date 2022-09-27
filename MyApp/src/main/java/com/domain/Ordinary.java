package com.domain;

import com.constant.NumberType;

import java.util.Objects;
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
        this.realVal = this.value;
    }


    @Override
    public void getRandom(int range) {
        /** 生成数值 */
        this.value = new Random().nextInt(range) + 1;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordinary ordinary = (Ordinary) o;
        return value == ordinary.value;
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
