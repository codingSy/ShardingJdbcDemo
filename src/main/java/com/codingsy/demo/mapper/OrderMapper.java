package com.codingsy.demo.mapper;

import com.codingsy.demo.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import com.codingsy.demo.entity.Order;

@Mapper
public interface OrderMapper {
    /**
     * 保存
     */
    void save(Order order);

    /**
     * 查询
     * @param id
     * @return
     */
    Order getById(Long id);

    OrderInfo getOrderInfoByUserId(Long userId);

}

