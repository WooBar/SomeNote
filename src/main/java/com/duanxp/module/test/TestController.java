package com.duanxp.module.test;

import com.duanxp.module.test.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @ClassName: TestController
 * @Description:
 * @Author duanxp
 * @Date 2020/05/28 09:43
 */
@RestController
public class TestController {


    @Autowired
    private TestDao testDao;

    @RequestMapping("testinsertbatch")
    public void temp(@RequestBody TTestInfo tTestInfo){


        int num = 0;
        ArrayList<TTestInfo> objects = new ArrayList<>();
        ArrayList<TTestInfo> objects2 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {

            TTestInfo insert = new TTestInfo();
            insert.setFlag(String.valueOf(i));
            insert.setType(String.valueOf(i));
            insert.setName(String.valueOf(i));
            insert.setPass(String.valueOf(i));
            objects.add(insert);

            for (int i2 = 0; i < 1000000; i++) {

                TTestInfo insert1 = new TTestInfo();
                insert1.setFlag(String.valueOf(i));
                insert1.setType(String.valueOf(i));
                insert1.setName(String.valueOf(i));
                insert1.setPass(String.valueOf(i));
                objects2.add(insert1);

            }

            num ++;


        }

        if (num == 1000000) {
            int i = testDao.insertBatch(objects);
            System.out.println(i);
        }

        System.out.println("结束~~~~~~~~~~~~~~~~~~~~~~~~");

    }


}
