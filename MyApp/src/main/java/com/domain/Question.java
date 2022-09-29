package com.domain;

import com.constant.NumberType;
import com.constant.Operator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Question {
    /** 数字的数量 */
    int numsCount;

    /** 数字集合 */
    private List<Type> nums;

    /** 操作符队列 */
    private Queue<Operator> ops = new LinkedList<>();

    /** 题目字符串 */
    private StringBuilder questionString = new StringBuilder();

    /** 题目答案 */
    private Type answer = new Ordinary();

    /** 随机对象 */
    private Random random = new Random();

    /** 数值限定范围 */
    private int range;

    /** 算式类型 */
    int equation;

    public String generateQuestion() {
        /** 随机生成2~4个数字 */
//        numsCount = random.nextInt(3) + 2;
        numsCount = 4;
        range = 10;
        switch (numsCount) {
            /** 当生成两个数字 */
            case 2 : {
                /** 生成两个随机数 */
                Type a = getRandomTypeNum(), b = getRandomTypeNum();
                /** 生成一个操作符 */
                getRandomOp();
                Operator operator = ops.poll();
                /** 判断计算结果是否存在负数 */
                if (isNeedSwap(a,b,operator)) {
                    Type temp = a;
                    a = b;
                    b = temp;
                }
                /** 生成算式字符串 */
                generateQuestionString(a,b,operator,false);
                break;

            }
            /** 当生成三个数字 */
            case 3 : {
                /** 随机产生四种类型的算式 */
                equation = random.nextInt(3) + 2;
                /** 随机生成三个数 */
                Type a = getRandomTypeNum(), b = getRandomTypeNum(), c = getRandomTypeNum();
                /** 随机生成操作符 */
                getRandomOp();
                Operator firstOperator = ops.poll();
                Operator secondOperator = ops.poll();

                if(equation == 2 || equation == 3) {  // 表示(1 + 2) + 3 或 1 + (2 + 3)
                    if(isNeedSwap(a, b, firstOperator)) {
                        Type temp = a;
                        a = b;
                        b = temp;
                    }
                    // 生成算式字符串
                    generateQuestionString(a, b, firstOperator, true);
//                    Type res = cal(a, b, firstOperator);
//                    boolean isSwap = isNeedSwap(res, c, secondOperator);
                    if(c.getNumType().getCode() == NumberType.FRACTION.getCode()) {
                        Fraction cc = (Fraction) c;
                        questionString.insert(0, " ").insert(0, secondOperator.getSign()).insert(0, " ");
                        questionString.insert(0, cc.generateStr());
                    } else {
                        Ordinary cc = (Ordinary) c;
                        questionString.insert(0, " ").insert(0, secondOperator.getSign()).insert(0, " ");
                        questionString.insert(0, cc.getValue());
                    }
                } else if(equation == 4) { // 1 + 2 + 3
                    // 优先级判断，(加为1, 减为2 - 1) / 2 后为0， 乘除号运算后为1
                    if((firstOperator.getCode() - 1) / 2 >= (secondOperator.getCode() - 1) / 2) {
                        if(isNeedSwap(a, b, firstOperator)) {
                            Type temp = a;
                            a = b;
                            b = temp;
                        }
                        // 生成算式字符串
                        generateQuestionString(a, b, firstOperator, false);
//                        Type res = cal(a, b, firstOperator);
//                        boolean isSwap = isNeedSwap(res, c, secondOperator);
                        if(c.getNumType().getCode() == NumberType.FRACTION.getCode()) {
                            Fraction cc = (Fraction) c;
                            questionString.insert(0, " ").insert(0, secondOperator.getSign()).insert(0, " ");
                            questionString.insert(0, cc.generateStr());
                        } else {
                            Ordinary cc = (Ordinary) c;
                            questionString.insert(0, " ").insert(0, secondOperator.getSign()).insert(0, " ");
                            questionString.insert(0, cc.getValue());
                        }
                    } else {
                        if(isNeedSwap(b, c, secondOperator)) {
                            Type temp = b;
                            b = c;
                            c = temp;
                        }
                        // 生成算式字符串
                        generateQuestionString(b, c, secondOperator, false);
//                        Type res = cal(b, c, secondOperator);
//                        boolean isSwap = isNeedSwap(a, res, firstOperator);
                        if(a.getNumType().getCode() == NumberType.FRACTION.getCode()) {
                            Fraction aa = (Fraction) a;
                            questionString.append(" ").append(firstOperator.getSign()).append(" ");
                            questionString.append(aa.generateStr());
                        } else {
                            Ordinary aa = (Ordinary) a;
                            questionString.append(" ").append(firstOperator.getSign()).append(" ");
                            questionString.append(aa.getValue());
                        }
                    }
                }
                break;
            }
            /** 当生成四个数字 */
            case 4 : {
                // 算式5~7号
                equation = random.nextInt(3)+5;
                // 随机生成四个数
                Type a = getRandomTypeNum(), b = getRandomTypeNum(), c = getRandomTypeNum(), d = getRandomTypeNum();
                // 随机生成操作符
                getRandomOp();
                Operator firstOP = ops.poll();
                Operator secondOP = ops.poll();
                Operator thirdOP = ops.poll();
                if(equation == 5 || equation == 6 || equation == 7) {
                    if(isNeedSwap(a, b, firstOP)) {
                        Type temp = a;
                        a = b;
                        b = temp;
                    };
                    // 生成算式字符串
                    generateQuestionString(a, b, firstOP, true);
                    if((secondOP.getCode() - 1) / 2 >= (thirdOP.getCode() - 1) / 2) {
                        if(c.getNumType().getCode() == NumberType.FRACTION.getCode()) {
                            Fraction cc = (Fraction) c;
                            questionString.insert(0, " ").insert(0, secondOP.getSign()).insert(0, " ");
                            questionString.insert(0, cc.generateStr());
                        } else {
                            Ordinary cc = (Ordinary) c;
                            questionString.insert(0, " ").insert(0, secondOP.getSign()).insert(0, " ");
                            questionString.insert(0, cc.getValue());
                        }
                        if(d.getNumType().getCode() == NumberType.FRACTION.getCode()) {
                            Fraction dd = (Fraction) d;
                            questionString.insert(0, " ").insert(0, thirdOP.getSign()).insert(0, " ");
                            questionString.insert(0, dd.generateStr());
                        } else {
                            Ordinary dd = (Ordinary) d;
                            questionString.insert(0," ").insert(0, thirdOP.getSign()).insert(0, " ");
                            questionString.insert(0, dd.getValue());
                        }
                    } else {
                        if(isNeedSwap(c, d, thirdOP)) {
                            Type temp = c;
                            c = d;
                            d = temp;
                        };

                        String temp = questionString.toString();
                        questionString = new StringBuilder();
                        generateQuestionString(c, d, thirdOP, false);
                        questionString.append(" ").append(secondOP.getSign()).append(" ");
                        questionString.append(temp);
                    }
                }
//                System.out.println(questionString);
                break;
            }
        }
        return questionString.toString();
    }


    /** 随机生成运算符 */
    public void getRandomOp() {
        for (int i = 0; i < numsCount -1 ; i++) {
            int code = random.nextInt(4) + 1;
            Operator operator = null;
            switch (code) {
                case 1: {
                    operator = Operator.ADD;
                    break;
                }
                case 2: {
                    operator = Operator.SUB;
                    break;
                }
                case 3: {
                    operator = Operator.MUL;
                    break;
                }
                case 4: {
                    operator = Operator.DIV;
                    break;
                }
            }
            /** 将产生的运算符放入运算符队列 */
            ops.add(operator);
        }
    }

    /** 生成一个随机类型的数字  */
    public Type getRandomTypeNum() {
        /** 随机生成code的值为1或2，1表示普通数字，2表示分数 */
        int code = random.nextInt(2) + 1;
        if( code == NumberType.ORDINARY.getCode()) {
            Ordinary ordinary = new Ordinary();
            ordinary.getRandom(range);
            return ordinary;
        } else if(code == NumberType.FRACTION.getCode()) {
            Fraction fraction = new Fraction();
            fraction.getRandom(range);
            return fraction;
        }
        return null;
    }

    /** 生成算式字符串 */
    public void generateQuestionString(Type a, Type b, Operator operator, Boolean hasBreaket) {
        /** hasBreaket为true时，添加括号 */
        if(hasBreaket) {
            questionString.append("( ");
        }
        /** 获取数字的类型 */
        int aType = a.numberType.getCode(), bType = b.getNumType().getCode();
        /** 按不同数字类型，进行对应操作 */
        if(aType == NumberType.ORDINARY.getCode() && bType == NumberType.ORDINARY.getCode()) {
            Ordinary aa = (Ordinary)a, bb = (Ordinary)b;
            questionString.append(aa.getValue()).append(" ").append(operator.getSign()).append(" ").append(bb.getValue());
        } else if(aType == NumberType.FRACTION.getCode() && bType == NumberType.FRACTION.getCode()) {
            Fraction aa = (Fraction)a, bb = (Fraction)b;
            questionString.append(aa.generateStr()).append(" ").append(operator.getSign()).append(" ").append(bb.generateStr());
        } else {
            if(aType == NumberType.FRACTION.getCode()) {
                Fraction aa = (Fraction)a;
                Ordinary bb = (Ordinary)b;
                questionString.append(aa.generateStr()).append(" ").append(operator.getSign()).append(" ").append(bb.getValue());
            } else {
                Ordinary aa = (Ordinary)a;
                Fraction bb = (Fraction)b;
                questionString.append(aa.getValue()).append(" ").append(operator.getSign()).append(" ").append(bb.generateStr());
            }
        }
        /** hasBreaket为true时，添加括号 */
        if(hasBreaket) {
            questionString.append(" )");
        }

    }

    /** 判断是否有减号，且结果为负数 */
    public Boolean isNeedSwap(Type a, Type b, Operator operator) {

        if(operator.getCode() == Operator.SUB.getCode() && a.getRealVal() < b.getRealVal()) {
            return true;
        }
        return false;
    }



}
