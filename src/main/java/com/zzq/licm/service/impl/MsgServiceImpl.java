package com.zzq.licm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzq.licm.mapper.MsgMapper;
import com.zzq.licm.po.Msg;
import com.zzq.licm.service.MsgService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Example example = new Example(Msg.class);
        example.createCriteria().andEqualTo("id",id);
        List<Msg> list = msgMapper.selectByExample(example);
        if( list.size()>0 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Map<String ,Object> selectListMsgByPage(int page, int size) {
        // set 第几页，一页获取多少条
        Page<Object> objects = PageHelper.startPage(page, size);
        // example 查询
        Example example = new Example(Msg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId","zhangzq");
        // 获取数据
        List<Msg> list = msgMapper.selectByExample(example);
        PageInfo<Msg> pageInfo = new PageInfo<>(list);

        Map<String , Object> result = new HashMap<>();
        result.put("total",pageInfo.getTotal());
        result.put("list",pageInfo.getList());
        return result;
    }

    @Override
    public int selectMsgCount() {
        return msgMapper.selectCount(null);
    }
}
