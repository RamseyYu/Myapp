package com.main;

import com.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int b = 3;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < b; i++) {
            Question question = new Question();
            String s1 = question.generateQuestion();
            list.add(s1);
        }
        System.out.println(list);
    }
}
