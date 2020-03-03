package com.duanxp.module.testlbd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/9 0009
 */
public class Test {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("shekhar", "rahul", "sameer");
        Collections.sort(names, (one, second) -> one.length() - second.length());
        System.out.println(names);



        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));
//        features.







    }



}
