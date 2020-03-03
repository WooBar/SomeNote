package com.duanxp.module.testSwitch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/7/26 0026
 */
public class TestSwitch {


    public static void main(String[] args) {


        String str = "http://video.bzwcloud.com/image/default/E85242FC58D94A5E94FF787DBA5F61BB-6-2.png;http://video.bzwcloud.com/image/default/FD9DA370D05D47EDB599E5D21C54539D-6-2.png;";
        System.out.println(str);
        // 将字符串转换成集合
        List<String> asList = Arrays.asList(str.split(";"));
        asList.forEach(str1 -> System.out.println(" ----------> 链接："+str1));





        test("8");

        // 0 break 不执行default 执行完switch还执行循环
            /*        进入循环
                    0
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            test方法最后*/


            // 1 continue 不执行default  本次循环直接结束了
            /*        进入循环
                    1

                    进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            test方法最后*/
        // 2 return  直接结束循环
            /*进入循环
            2*/
        // 8 不再case里 执行default

            /*        进入循环
                    default
                    switch结束了

                            进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            进入循环
                    default
                    switch结束了
                            test方法最后*/

    }


    public static void test(String num){

        ArrayList<String> list = new ArrayList<>();

        list.add(num);
        Collections.addAll(list,"6","7","8");

        for (String s : list) {
            System.out.println("进入循环");
            switch (s){
                case "0":

                    System.out.println("0");
                    break;
                case "1":
                    System.out.println("1");

                    continue;
                case "2":
                    System.out.println("2");
                    return;
                default:

                    System.out.println("default");

            }

            System.out.println("switch结束了");

        }

        System.out.println("test方法最后");


    }




//    Robot




}
