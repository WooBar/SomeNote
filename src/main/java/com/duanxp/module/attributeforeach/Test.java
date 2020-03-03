package com.duanxp.module.attributeforeach;

import java.lang.reflect.Field;

/**
 * @ClassName: Test
 * @Description:
 * @Author duanxp
 * @Date 2020/01/07 16:22
 */
public class Test {

    public static void main(String[] args) {


        Animal animal = new Animal();
        animal.setAge(11);
        animal.setName("动物");
        animal.setPrice(11.03);

        Field[] fields = animal.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field.getName());
//            System.out.println(field.);

                switch (field.getName()) {
                    case "age":

                        break;
                    case "price":

                        break;
                    case "name":
                        break;
                    default:
                }


        }


    }


}
