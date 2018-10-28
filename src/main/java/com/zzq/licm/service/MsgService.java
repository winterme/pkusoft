package com.zzq.licm.service;

import com.zzq.licm.po.Msg;

import java.util.List;
import java.util.Map;

public interface MsgService {

    int insertSelective(Msg msg);

    Msg selectMsgById(String id);

    Map<String ,Object> selectListMsgByPage(int start , int end);

    int selectMsgCount();

}
