package com.duanxp.module.choose.dao;

import com.duanxp.module.choose.pojo.ChooseLocationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author duanxp
 * @ClassName: ChooseController
 * @Description:
 * @date 2019/11/09 14:35
 */
public interface ChooseDao {

    /**
     * @title ChooseDao
     * @description
     * @param
     * @return
     * @author duanxp
     * @throws
     * @date 2019/11/09 16:55
     */
    void insert(ChooseLocationInfo insertInfo);
}
