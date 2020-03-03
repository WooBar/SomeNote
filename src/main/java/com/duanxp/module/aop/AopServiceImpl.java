package com.duanxp.module.aop;

import org.springframework.stereotype.Service;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/17 0017
 */
@Service
public class AopServiceImpl implements AopService{

    @Override
    public void test(AopDto aopDto) {

        System.out.println("测试aop实现类");


    }
}
