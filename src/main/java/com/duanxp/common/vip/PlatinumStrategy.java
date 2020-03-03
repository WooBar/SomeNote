package com.duanxp.common.vip;

/**
 * @ClassName: PlatinumStrategy
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 13:35
 */
public class PlatinumStrategy implements Strategy{
    @Override
    public double compute(long money) {
        System.out.println("白金会员 优惠50元，再打7折");
        return (money - 50) * 0.7;
    }
}
