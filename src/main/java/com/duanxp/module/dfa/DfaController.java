package com.duanxp.module.dfa;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @ClassName: DfaController
 * @Description:
 * @Author duanxp
 * @Date 2020/01/16 11:43
 */
@RestController
public class DfaController {


    @RequestMapping("/dfa")
    public void Test(@RequestBody String name){

        int length = name.length();

        SensitivewordFilter filter = new SensitivewordFilter();
        long beginTime = System.currentTimeMillis();

        Set<String> set = filter.getSensitiveWord(name, 1);

        long endTime = System.currentTimeMillis();

        System.out.println("敏感词长度 ------------> ："+length);
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime) + "  毫秒");

    }


}
