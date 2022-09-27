package com.constant;

/** 数字类型枚举类。用以对数字类型进行标识 */
public  enum NumberType {

    /** 普通的数（非分数） */
    ORDINARY(1),
    /** 分数 */
    FRACTION(2);

    int code;

    NumberType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
