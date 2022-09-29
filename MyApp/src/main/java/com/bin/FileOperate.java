package com.bin;/*
 * @author : bin
 * @description : 文件操作,写入题目,比对答案
 */

import com.domain.Question;
import org.junit.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static com.bin.NumberOperate.*;

public class FileOperate {

    //把文件读取到Properties集合
    public static Properties myLoad(String place) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader(place);
        prop.load(fr);
        fr.close();
        return prop;
    }


    //向指定文件写入表达式集合数据(判断如果出现负数就不写入文件中)
    public static void myStoreQuestion(String questionPlace,String answerPlace, int sum ,int range) throws IOException {
        Properties questionProp = new Properties();
        Properties answerProp = new Properties();
        int index = 1;
        while (index <=sum) {//如果出现负数就重新生成题目
            Question question = new Question(range);
            String s = question.generateQuestion();
            if (lastPolandExpression(s)!= null) {
                questionProp.setProperty("" + index, s);
                answerProp.setProperty(""+index,lastPolandExpression(s));
                index++;
            }
        }
        FileWriter fw1 = new FileWriter(questionPlace);
        questionProp.store(fw1, null);
        FileWriter fw2 = new FileWriter(answerPlace);
        answerProp.store(fw2, null);
        fw1.close();
        fw2.close();
    }

    //比较上传的答案是否正确,第一个参数是题目集合,第二个参数是结果集合
    public static void compareAnswer(Properties question, Properties answer) {
        Set<Object> keySet = answer.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Object key : keySet) {
            String questionS = question.get(key).toString();
            String answerTrue = lastPolandExpression(questionS);
            if (!answerTrue.equals(answer.get(key))) {
                stringBuilder.append(key.toString()).append(" ");
            }
        }
        String res = stringBuilder.toString();
        if (res.isEmpty() || res == null) {
            System.out.println("答案全部正确");
        } else {
            System.out.println("题目: " + res + " 结果有误");
        }
    }


}
