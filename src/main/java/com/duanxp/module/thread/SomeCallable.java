package com.duanxp.module.thread;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/22 0022
 */
public class SomeCallable implements Callable {
    @Override
    public Object call() throws Exception {
        return null;
    }




    public static void main(String[] args) {

        SomeCallable someCallable = new SomeCallable();
        FutureTask futureTask = new FutureTask<>(someCallable);
        Thread thread = new Thread(futureTask);
        thread.start();

        String a = "1";
        String test = test(a);
        System.out.println(test);

        BigDecimal s = new BigDecimal("5");
        BigDecimal m = new BigDecimal("1");
        System.out.println(s.divide(m));


    }

//    private static void testSwitch2(String status) {
//        var result = switch (status) {
//            case "" -> 1;
//            case  "", "" -> 2;
//            case "" -> 3;
//            default -> throw new RuntimeException("状态不正确");
//        };
//        System.out.println("result is " + result);
//    }

    public static String test(String aa){
            aa = "2";
            return aa;
    }


}
