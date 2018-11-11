package com.zzq;


import com.zzq.licm.po.Msg;
import com.zzq.licm.service.MsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    private final static Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private MsgService msgService;

    @Test
    public void testGetDataByPage(){
        Map<String, Object> data = msgService.selectListMsgByPage(0, 2);
        System.out.println(data.get("total"));
        List<Msg> list = (List<Msg>)data.get("list");
        for (Msg msg: list) {
            System.out.println( msg );
        }
        logger.debug("获取数据成功！");
    }

}
