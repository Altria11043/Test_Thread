package com.zca.lambda;

/**
 * lambda只能对接口中只有一个实现方法的进行简化
 * @author Altria
 * Date: 2/10/2019 上午 9:46
 */
public class TestLambda01 {
    public static void main(String[] args) {
        // 这里可以对这个接口进行简化
        Tlambda tl = (a, b)->{
            return a+b;
        };
        System.out.println(tl.lambda01(1,2));
    }
}

interface Tlambda{
    int lambda01(int a, int b);
}