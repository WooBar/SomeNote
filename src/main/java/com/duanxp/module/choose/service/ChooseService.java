package com.duanxp.module.choose.service;

import com.duanxp.module.choose.pojo.ChooseLocationInfo;

import java.io.UnsupportedEncodingException;

/**
 * @author duanxp
 * @ClassName: ChooseService
 * @Description:
 * @date 2019/11/09 14:39
 */
public interface ChooseService {
    
    /**  
     * @title ChooseService
     * @description 
     * @param 
     * @return  
     * @author duanxp
     * @throws
     * @date 2019/11/09 16:53
     */ 
    void saveTrace(ChooseLocationInfo insertInfo) throws UnsupportedEncodingException;
}
