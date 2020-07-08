package com.duanxp.common.vipforenum.fac;

import com.duanxp.common.vipforenum.RoleOperation;

/**
 * @ClassName: RootAdminRole
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 17:01
 */
public class RootAdminRole implements RoleOperation {

    private String roleName;

    public RootAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String ope() {
//        System.out.println("ROOT  权限");
        return "order list";
    }
}
