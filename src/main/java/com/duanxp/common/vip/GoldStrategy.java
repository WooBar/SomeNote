package com.duanxp.common.vip;

/**
 * @ClassName: GoldStrategy
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 13:35
 */
public class GoldStrategy implements Strategy{
    @Override
    public double compute(long money) {
        System.out.println("黄金会员 8折");
        return money * 0.8;
    }
}
