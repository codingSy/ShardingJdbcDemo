package com.codingsy.demo.mapper;

import com.codingsy.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 批量保存
     * @param users
     */
    void batchSave(@Param("users") List<User> users);

    /**
     * 查询
     * @param id
     * @return
     */
    User getByUserId(@Param("id")Long id);

    /**
     * 批量查询
     * @param id
     * @return
     */
    List<User> getByIds(@Param("ids")List<Long> id);

    /**
     *根据用户名查询
     * @param name
     * @return
     */
    User getByName(String name);

    List<User> getByCreateTime(@Param("createTime")String createTime);
}

