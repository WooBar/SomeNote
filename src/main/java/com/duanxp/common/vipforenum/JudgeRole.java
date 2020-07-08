package com.duanxp.common.vipforenum;

import com.duanxp.common.vipforenum.enu.RoleEnum;
import com.duanxp.common.vipforenum.fac.RoleFactory;
import com.duanxp.common.vipforenum.strategy.RoleContext;

/**
 * @ClassName: JudgeRole
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 16:19
 */
public class JudgeRole {


    //枚举方法
    public static String judge(String role){

        return RoleEnum.valueOf(role).ope();

    }

    public static String judge(RoleOperation roleOperation){

        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.excute();

    }

    public static void main(String[] args) {
        //枚举 写在了一个文件
//        String judge = judge(RoleEnum.ROLE_NORMA.name());
//        System.out.println(judge);

        //工厂 写了三个文件
        RoleOperation ope = RoleFactory.ope("ROLE_ORDER_ADMIN");
        System.out.println(ope.ope());

        //策略
//        RootAdminRole rootAdminRole = new RootAdminRole("ROLE_ORDER_ADMIN");
//        judge(rootAdminRole);

    }




}
