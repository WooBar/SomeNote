package com.duanxp.javabase.optional;

import java.util.Objects;
import java.util.Optional;

/**
 * @ClassName: TestOptional
 * @Description:
 * @Author duanxp
 * @Date 2020/06/05 15:37
 */
public class TestOptional {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(2);

        //01 get方法
        Optional.ofNullable(person).get();

        //02 判读是否为空
        if (Optional.ofNullable(person).isPresent()){
            //写不为空的逻辑
            System.out.println("不为空");
        } else{
            //写为空的逻辑
            System.out.println("为空");
        }

        Optional.ofNullable(person).ifPresent(p -> System.out.println("年龄"+p.getAge()));

        Optional<Person> person1 = Optional.ofNullable(person).filter(p -> p.getAge() < 50);
        Person person2 = person1.get();
        System.out.println(person2.getAge());


    }

    public static String test1() {


        Person person = null;

        Optional.ofNullable(person).orElse(new Person());


        Objects.requireNonNull(person, "");

        Optional<Person> person1 = Optional.of(person);


        return null;
    }
}
