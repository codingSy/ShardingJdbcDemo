package com.codingsy.demo.mapper;

import java.util.List;

import com.codingsy.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {

    /**
     * 查询
     * @param id
     * @return
     */
    List<Goods> getById(@Param("id") Long id);
}

