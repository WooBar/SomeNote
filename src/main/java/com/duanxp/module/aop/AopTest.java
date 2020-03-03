package com.duanxp.module.aop;

import com.google.common.collect.Maps;
import net.sf.json.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Version
 * @Author dxp
 * @Date 2019/8/17 0017
 */
@Aspect
@Component
public class AopTest {


    @Pointcut(value = "execution(* com.duanxp.module.aop.AopServiceImpl.test(AopDto))")
    public void pointcut() {
    }



    @Before("pointcut()")
    public String before(JoinPoint joinPoint) {
        System.out.println(" ----------------> before");

        System.out.println(joinPoint.getArgs());

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            Object arg2 = arg;
            AopDto arg1 = (AopDto) arg;


            System.out.println(" arg2 ---------> "+arg2);


            System.out.println(" arg1 ---------> "+arg1);
            System.out.println(arg1.getUsername());
            System.out.println(arg1.getPassword());

            String s = arg2.toString();
            System.out.println(s);

            net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(arg2);
            System.out.println(jsonObject);



            AopDto aop = (AopDto) JSONObject.toBean(jsonObject, AopDto.class);
            System.out.println(aop.getUsername());
            System.out.println(aop.getPassword());
            System.out.println(aop);

            System.out.println(aop.toString());


            System.out.println();
        }


        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        signature.getName();
        //AOP代理类的名字
        signature.getDeclaringTypeName();
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        //获取请求参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }


        return "";
    }




    @Around("pointcut()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" ----------------> around");


        System.out.println(joinPoint.getArgs().getClass());

        /**
         * 这一不执行的话，before 不执行
         */
        ProceedingJoinPoint joinPoint1 = (ProceedingJoinPoint) joinPoint;
        joinPoint1.proceed();




        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        signature.getName();
        //AOP代理类的名字
        signature.getDeclaringTypeName();
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        //获取请求参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }


        return "";
    }

    @After("pointcut()")
    public void commit() {
        System.out.println("after commit");
    }

    @AfterReturning(returning = "returnObject", value = "pointcut()")
    public void afterReturning(JoinPoint joinPoint, String returnObject) {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing afterThrowing  rollback");
    }





}
