package com.duanxp.common.vipforenum.fac;

import com.duanxp.common.vipforenum.RoleOperation;

/**
 * @ClassName: RootAdminRole
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 17:01
 */
public class NormalAdminRole implements RoleOperation {

    private String roleName;

    public NormalAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String ope() {
        return "NORMAL  权限";
    }
}
