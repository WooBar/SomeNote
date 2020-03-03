package com.duanxp.module.animal;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/20 0020
 */
public class TestAnimal {

    static int countLegs (List<? extends Animal> animals ) {
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs2 (List<Dog> animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }


    private <K extends Animal, E extends Animal> E test(K arg1, E arg2){
        E result = arg2;
//        arg2.compareTo(arg1);
        //.....
        return result;
    }

    private <T> void test(List<? super T> dst, List<T> src){
        for (T t : src) {
            dst.add(t);
        }
    }



    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs( dogs );
        // 报错
//        countLegs1(dogs);
        countLegs2(dogs);

    }





}
