package com.domain;

import com.constant.NumberType;

public abstract class Type {
    /** 数字类型标识 */
    protected NumberType numberType;
    /** 真实数值 */
    protected double realVal;

    public Type() {
    }

    /** 获取随机数 */
    public abstract void getRandom(int range);

    public NumberType getNumType() {
        return numberType;
    }

    public void setNumType(NumberType numType) {
        this.numberType = numType;
    }

    public double getRealVal() {
        return realVal;
    }

    public void setRealVal(double realVal) {
        this.realVal = realVal;
    }
}
