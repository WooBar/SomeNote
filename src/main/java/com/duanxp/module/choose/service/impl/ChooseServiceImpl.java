package com.duanxp.module.choose.service.impl;

import com.duanxp.common.ip.IpUtil;
import com.duanxp.common.util.IDUtil;
import com.duanxp.module.choose.dao.ChooseDao;
import com.duanxp.module.choose.pojo.ChooseLocationInfo;
import com.duanxp.module.choose.service.ChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author duanxp
 * @ClassName: ChooseServiceImpl
 * @Description:
 * @date 2019/11/09 14:39
 */
@Service
public class ChooseServiceImpl implements ChooseService {

    @Autowired
    private ChooseDao chooseDao;

    @Override
    public void saveTrace(ChooseLocationInfo insertInfo) throws UnsupportedEncodingException {

        insertInfo.setId(IDUtil.getUUID());
        insertInfo.setStatus("1");
        String addresses = IpUtil.getAddresses("ip="+insertInfo.getIp(),"utf-8");
        insertInfo.setLocation(addresses);
        chooseDao.insert(insertInfo);



    }



}
