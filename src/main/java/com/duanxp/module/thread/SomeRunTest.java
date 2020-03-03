package com.duanxp.module.thread;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/22 0022
 */
public class SomeRunTest {


    public static void main(String[] args) {
        Runnable oneRunnable = new SomeRunnable();
        Thread oneThread = new Thread(oneRunnable,"线程一");
        Thread oneThread1 = new Thread(oneRunnable,"线程二");
        oneThread.start();
        oneThread1.start();
    }


}
