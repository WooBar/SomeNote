package com.duanxp.module.test.dao;

import com.duanxp.module.test.TTestInfo;

import java.util.ArrayList;

/**
 * @ClassName: TestDao
 * @Description:
 * @Author duanxp
 * @Date 2020/05/28 09:45
 */
public interface TestDao {

    int insert(TTestInfo tTestInfo);

    int insertBatch(ArrayList<TTestInfo> objects);
}
