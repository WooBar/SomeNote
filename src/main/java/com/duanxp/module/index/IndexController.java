package com.duanxp.module.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Version
 * @Author dxp
 * @Date 2019/7/30 0030
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index2(){
        System.out.println("index");
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}
