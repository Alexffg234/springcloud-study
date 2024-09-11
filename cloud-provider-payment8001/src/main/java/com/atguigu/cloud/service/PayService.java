package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * 支付服务接口，提供对支付信息的CRUD操作
 */
public interface PayService {

    /**
     * 添加支付信息
     *
     * @param pay 支付对象，包含支付的所有相关信息
     * @return 返回添加操作的结果，1表示成功
     */
    int add(Pay pay);

    /**
     * 删除支付信息
     *
     * @param id 支付信息的唯一标识符
     * @return 返回删除操作的结果，1表示成功
     */
    int delete(Integer id);

    /**
     * 更新支付信息
     *
     * @param pay 包含需要更新的支付信息的支付对象
     * @return 返回更新操作的结果，1表示成功
     */
    int update(Pay pay);

    /**
     * 根据ID获取支付信息
     *
     * @param id 支付信息的唯一标识符
     * @return 返回对应的支付对象，如果找不到则返回null
     */
    Pay getById(Integer id);

    /**
     * 获取所有支付信息
     *
     * @return 返回一个包含所有支付对象的列表
     */
    List<Pay> getAll();
}

