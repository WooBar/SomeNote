package com.duanxp.module.chifan.service.impl;

import com.duanxp.module.chifan.dao.ChiFanDao;
import com.duanxp.module.chifan.service.ChiFanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version
 * @Author dxp
 * @Date 2019/11/6 0006
 */
@Service
public class ChiFanServiceImpl implements ChiFanService {



    @Autowired
    private ChiFanDao chifanDao;



    @Override
    public List<String> getList(String s){

        List<String> findlist = chifanDao.findlist(s);

        return findlist;
    }

}
