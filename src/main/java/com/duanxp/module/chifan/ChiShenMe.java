package com.duanxp.module.chifan;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Version
 * @Author dxp
 * @Date 2019/10/9 0009
 */
public class ChiShenMe {


    public static void main(String[] args) {
        String chi = chi();
        System.out.println(chi);
    }


    public static String chi(){

        //智能选餐系统 以下代码价值十个亿
        ArrayList<String> food = new ArrayList<>();
        food.add(1,"烤肉拌饭");
        food.add(2,"水饺");
        food.add("炸串");
        food.add("排骨米饭");
        food.add("煎饺");
        food.add("粥");
        food.add("炒菜快餐");
        food.add("嫩牛五方");
        food.add("黄焖鸡");
        food.add("烤鸭");
        food.add("炸鸡");
        food.add("咖喱汤饭");
        food.add("灌汤包");
        food.add("蟹黄包");
        food.add("汉堡");
        food.add("紫燕百味鸡");
        food.add("锅盔");
        food.add("肉饼");
        food.add("糁汤");
        food.add("驴肉火烧");
        food.add("肠粉");
        food.add("螺蛳粉");
        food.add("酸菜鱼");
        food.add("卷饼");
        food.add("可立餐");
        food.add("包子");
        food.add("鸡架");
        food.add("油饼");
        food.add("小笼包");
        food.add("炒饭");
        food.add("锅贴");
        food.add("卤煮");
        food.add("披萨");
        food.add("麻辣烫");
        food.add("面条");
        food.add("炒饭");
        food.add("烤鱼饭");
        food.add("盖浇饭");
        food.add("疙瘩汤");
        food.add("鳕鱼饭");
        food.add("肉夹馍");
        food.add("羊汤");
        food.add("西北风");
        food.add("东北风");
        food.add("饿死吧");
        food.add("请联系管理员，您需要一顿暴打");
        food.add("面包");

        int size = food.size();

        Random random = new Random();
        int i = random.nextInt(size);
        System.out.println(i);

        String result = food.get(i);

        return result;
    }

}



