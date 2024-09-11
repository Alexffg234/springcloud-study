package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "payService")
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        //insertSelective()当存储对象的属性为空，会存取数据库字段的默认值
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        //deleteByPrimaryKey()删除主键为id的数据
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        //updateByPrimaryKeySelective()当存储对象的属性为空，不会更新数据库字段
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        //selectByPrimaryKey()根据主键查询
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        //selectAll()查询所有
        return payMapper.selectAll();
    }
}
