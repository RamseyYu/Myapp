package com.bin;
/*
 * @author : bin
 * @description :测试bin包下的内容
 */

import org.junit.Assert;
import org.junit.Test;

import static com.bin.NumberOperate.*;

public class BinTest {

    //测试数据加法
    @Test
    public void TestAdd(){
        Assert.assertEquals("7/6",add("1/2", "2/3"));
        Assert.assertEquals("2",add("1","1"));
        Assert.assertEquals("4/3",add("1","1/3"));
        Assert.assertEquals("1/3",add("0","1/3"));

    }

    //测试数据减法
    @Test
    public void testSubtract(){
        Assert.assertEquals(null,subtract("1/2", "2/3"));
        Assert.assertEquals("0",subtract("1","1"));
        Assert.assertEquals("2/3",subtract("1","1/3"));
        Assert.assertEquals("1/3",subtract("1/3","0"));
    }

    @Test
    //测试提取最大公约数
    public void testGcd(){
        Assert.assertEquals(3,gcd(6,3));
        Assert.assertEquals(1,gcd(1,3));
        Assert.assertEquals(1,gcd(3,1));
        Assert.assertEquals(2,gcd(18,4));
    }

    @Test
    //测试化简分数
    public void testSimplify(){
        Assert.assertEquals("1",simplify(1,1));
        Assert.assertEquals("3",simplify(3,1));
        Assert.assertEquals("3",simplify(12,4));
        Assert.assertEquals("3/2",simplify(12,8));
    }
}
