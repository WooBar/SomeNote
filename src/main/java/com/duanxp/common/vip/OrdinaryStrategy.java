package com.duanxp.common.vip;

/**
 * @ClassName: OrdinaryStrategy
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 13:33
 */
public class OrdinaryStrategy implements Strategy{

    @Override
    public double compute(long money) {
        System.out.println("普通会员 不打折");
        return money;
    }
}
