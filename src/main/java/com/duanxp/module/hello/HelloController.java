package com.duanxp.module.hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version
 * @Author dxp
 * @Date 2019/7/30
 */
@RestController
public class HelloController {



    @RequestMapping("/hello")
    public String index(@RequestBody String s){

        System.out.println(s);

        return "Hello world";
    }



}
