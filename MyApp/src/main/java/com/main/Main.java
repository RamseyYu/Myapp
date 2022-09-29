package com.main;

import com.bin.FileOperate;
import com.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.bin.FileOperate.*;
import static com.bin.NumberOperate.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 10;
        int range = 10;
        for (int i = 0; i < args.length; i++) {
            if ("-n".equals(args[i])) {
                sum = Integer.valueOf(args[i + 1]);
            }
            if ("-r".equals(args[i])) {
                range = Integer.valueOf(args[i + 1]);
            }
        }
                myStoreQuestion("D:\\question.txt","D:\\Answers.txt",sum,range);
        Properties question = myLoad("D:\\question.txt");

        System.out.println("***********欢迎使用四则运算题目生成程序***********");
        System.out.println("题目已生成，请在 D:\\question.txt 文件中查看题目，并在 answer.txt 中完成答题");
        System.out.println("若想知道答案是否正确，请按 1 进行批改操作");
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        if (i == 1) {
            Properties answer = myLoad("D:\\answer.txt");
            compareAnswer(question,answer);
        }
    }
}
