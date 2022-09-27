package com.constant;

public enum Operator {
    /** 加减乘除 */
    ADD(1,'+'),
    SUB(2, '-'),
    MUL(3, '×'),
    DIV(4, '÷');
    
    int code;
    char sign;

    Operator(int code,char sign) {
        this.code = code;
        this.sign = sign;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }
}
