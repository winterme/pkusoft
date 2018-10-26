package com.zzq.licm.service;

import com.zzq.licm.po.Msg;

public interface MsgService {

    int insertSelective(Msg msg);

    Msg selectMsgById(String id);

}
