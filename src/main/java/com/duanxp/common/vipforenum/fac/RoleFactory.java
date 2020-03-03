package com.duanxp.common.vipforenum.fac;

import com.duanxp.common.vipforenum.RoleOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RoleFactory
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 17:04
 */
public class RoleFactory {

    static Map<String, RoleOperation> operationMap = new HashMap<>();

    static {

        operationMap.put("ROLE_ROOT_ADMIN",new RootAdminRole("ROLE_ROOT_ADMIN"));

        operationMap.put("ROLE_ORDER_ADMIN",new OrderAdminRole("ROLE_ORDER_ADMIN"));

        operationMap.put("ROLE_NORMAL_ADMIN",new NormalAdminRole("ROLE_NORMAL_ADMIN"));

    }

    public static RoleOperation ope(String name){
        return operationMap.get(name);
    }


}
