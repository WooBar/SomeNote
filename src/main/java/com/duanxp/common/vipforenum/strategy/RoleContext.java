package com.duanxp.common.vipforenum.strategy;

import com.duanxp.common.vipforenum.RoleOperation;

/**
 * @ClassName: RoleContext
 * @Description:
 * @Author duanxp
 * @Date 2019/12/30 14:10
 */
public class RoleContext {

    private RoleOperation roleOperation;

    public RoleContext(RoleOperation roleOperation) {
        this.roleOperation = roleOperation;
    }

    public String excute(){

        return roleOperation.ope();
    }

}
