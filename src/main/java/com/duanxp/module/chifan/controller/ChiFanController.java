package com.duanxp.module.chifan.controller;

import com.duanxp.common.file.Test;
import com.duanxp.common.ip.IpUtil;
import com.duanxp.module.chifan.service.ChiFanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


/**
 * @Version
 * @Author dxp
 * @Date 2019/10/9 0009
 */
@RequestMapping
@Controller
public class ChiFanController {


    @Autowired
    private ChiFanService chiFanService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("choose2333")
    public String gansha(){

        return "choose";
    }


    @RequestMapping(value = "/chifan2333")
    public String chifan(Model mv){

        //获取吃什么
        String chi = chi();
        mv.addAttribute("info", chi);

        //获取当前时间
        LocalDateTime time = LocalDateTime.now();
        String replace = time.toString().replace("T", " ").substring(0,19);
        System.out.println(time);
        System.out.println(replace);
        mv.addAttribute("time",replace);


        //获取ip
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        System.out.println(requestURL);

        String requestURI = httpServletRequest.getRequestURI();
        System.out.println(requestURI);

        String contextPath = httpServletRequest.getContextPath();
        System.out.println(contextPath);

        String ipAddr = com.duanxp.common.ip.IpUtil.getIpAddr(httpServletRequest);
        System.out.println(ipAddr);

        String ipAddress = IpUtil.getIpAddress(httpServletRequest);
        System.out.println(ipAddress);


        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub  这里放你要执行的方法
                Test.getLevelOneFile("C:\\Users\\Administrator\\Documents\\WeChat Files\\wxid_pu7afe31cp8141\\FileStorage");
            }
        }).start();



        return "chifan";
    }





    @RequestMapping("add2333")
    public String add(){


        return "add";
    }

    @RequestMapping("xuan22333")
    public String xuan(HttpServletRequest request, HttpServletResponse response, String food){

        System.out.println("1 ------> "+food);

        return "add";
    }

    @RequestMapping("xuan2333")
    public ModelAndView xuan2(HttpServletRequest request, HttpServletResponse response, String[] food){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/final");

        int size = food.length;

        Random random = new Random();
        int i = random.nextInt(size);
        System.out.println(i);

        String result = food[i];


        mv.addObject("info", result);

        LocalDateTime time = LocalDateTime.now();
        String replace = time.toString().replace("T", " ").substring(0,19);

        System.out.println(replace);
        mv.addObject("time",replace);

        return mv;
    }



    private static String chi(){

        //智能选餐系统 以下代码价值十个亿
        ArrayList<String> food = new ArrayList<>();
        food.add("烤肉拌饭");
        food.add("水饺");
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
        food.add("请联系管理员，领取一顿毒打");
        food.add("面包");

        int size = food.size();

        Random random = new Random();
        int i = random.nextInt(size);
        System.out.println(i);

        String result = food.get(i);

        return result;
    }

    public static void main(String[] args) {
        String chi = chi();
        System.out.println(chi);
    }


}
