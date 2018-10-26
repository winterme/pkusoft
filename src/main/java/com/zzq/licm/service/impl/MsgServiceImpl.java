package com.zzq.licm.service.impl;

import com.zzq.licm.mapper.MsgMapper;
import com.zzq.licm.po.Msg;
import com.zzq.licm.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(value = "licmTransation")
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public int insertSelective(Msg msg) {
        String id = UUID.randomUUID().toString();
        msg.setId(id);
        return msgMapper.insertSelective(msg);
    }

    @Override
    public Msg selectMsgById(String id) {
        return msgMapper.selectByPrimaryKey(id);
    }
}
