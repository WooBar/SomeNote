package com.duanxp.common.vipforenum.enu;

import com.duanxp.common.vipforenum.RoleOperation;

/**
 * @ClassName: RoleEnum
 * @Description:
 * @Author duanxp
 * @Date 2019/12/23 16:14
 */
public enum RoleEnum implements RoleOperation {

    ROLE_ROOT_ADMIN{
        @Override
        public String ope() {
            System.out.println("总管理员权限");
            return null;
        }
    },


    ROLE_ORDER_ADMIN{
        @Override
        public String ope() {
            System.out.println("订单权限");
            return null;
        }
    },

    ROLE_NORMA{
        @Override
        public String ope() {
            System.out.println("普通权限");
            return null;
        }
    }

}
