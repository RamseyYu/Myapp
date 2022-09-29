package com.main;

import com.bin.FileOperate;
import com.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.bin.FileOperate.*;
import static com.bin.NumberOperate.*;

public class Main {
    public static void main(String[] args) throws IOException {
        myStoreQuestion("D:\\question.txt",100,10);
        Properties question = myLoad("D:\\question.txt");
        Properties answer = myLoad("D:\\answer.txt");
        compareAnswer(question,answer);
    }
}
