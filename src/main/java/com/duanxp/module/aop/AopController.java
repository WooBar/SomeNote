package com.duanxp.module.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/17 0017
 */
@RestController
public class AopController {

    @Autowired
    private AopService aopService;

    @RequestMapping("aop")
    public String test(@RequestBody AopDto aopDto) throws Exception{

        aopService.test(aopDto);
        return "index";
    }

}
