package com.duanxp.module.thread;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/22 0022
 */
public class SomeThead     {


    public static void main(String[] args){
        SomeThread oneThread = new SomeThread();
        oneThread.start();
    }

    private static class SomeThread extends Thread{


    }


}
