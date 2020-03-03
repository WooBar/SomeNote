package com.duanxp.common.util;

import org.apache.commons.lang.math.RandomUtils;

public class RandomUtil {

	/**
	 * 随机数 2015年3月3日 09:23:25
	 * 
	 * @param num
	 * @category 产生几位数据
	 * @author gongliwei
	 * @return
	 */
	public static String getRandomNumber(int num) {
		StringBuilder sb = new StringBuilder(num);
		for (int i = 0; i < num; i++) {
			sb.append(RandomUtils.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 获取指定范围的随机数
	 * 
	 * @param min
	 *            最小数
	 * @param max
	 *            最大数
	 * @return
	 */
	public static int getRandomNumberRange(int min, int max) {
		int s = RandomUtils.nextInt(max - min + 1) + min;
		return s;
	}

	/**
	 * 16位随机字符串
	 * 
	 * @param length
	 *            长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < length; i++) {
			res.append(chars.charAt(RandomUtils.nextInt(chars.length())));
		}
		return res.toString();
	}

}
