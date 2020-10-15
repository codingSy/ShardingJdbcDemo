package com.codingsy.demo.test;

import com.codingsy.demo.Aplication;
import com.codingsy.demo.entity.Order;
import com.codingsy.demo.entity.User;
import com.codingsy.demo.mapper.GoodsMapper;
import com.codingsy.demo.mapper.OrderMapper;
import com.codingsy.demo.mapper.UserMapper;
import com.codingsy.demo.util.IdGenerator;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Aplication.class)
@WebAppConfiguration
public class UserTest {

    private final Gson gson = new Gson();
    @Resource
    UserMapper userMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    IdGenerator idGenerator;

    @Resource
    GoodsMapper goodsMapper;

    /**
     * 分布式Id
     */
    @Test
    public void getGeneratorId() {
        for (int j = 0; j < 100; j++) {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println(idGenerator.generateKey().toString());
                }
            }).start();
        }
    }

    /**
     * 创建用户
     */
    @Test
    public void saveUser() {
        for (Integer i = 0; i < 100; i++) {
            User user = new User();
            user.setName("sy" + i);
            user.setSex(i % 2);
            user.setPhone("12345678910");
            user.setEmail("123456@qq.com");
            user.setPassword("123456");
            userMapper.save(user);
        }
    }

    /**
     * 批量保存
     */
    @Test
    public void batchSaveUser() {
        List<User> users = Lists.newArrayList();
        for (Integer i = 0; i < 100; i++) {
            User user = new User();
            user.setName("sy" + i);
            user.setSex(i % 2);
            user.setPhone("12345678910");
            user.setEmail("123456@qq.com");
            user.setPassword("123456");
            users.add(user);
        }
        userMapper.batchSave(users);
    }

    /**
     * 创建订单
     */
    @Test
    public void saveOrder() {
        Order order = new Order();
        order.setUserId(116432607377883137L);
        order.setPayMoney(1400.2);
        order.setPayTime(new Date());
        orderMapper.save(order);
    }

    /**
     * 绑定表
     */
    @Test
    public void getOrderInfoByUserId() {
        System.out.println(gson.toJson(orderMapper.getOrderInfoByUserId(116432607377883137L)));
    }

    /**
     * 根据分片键获取用户
     */
    @Test
    public void getUserByUserId() {
        System.out.println(gson.toJson(userMapper.getByUserId(116432607629541377L)));
    }

    /**
     * 根据分片键批量获取用户
     */
    @Test
    public void getUserByUserds() {
        System.out.println(gson.toJson(userMapper.getByIds(Lists.newArrayList(12L, 33L))));
    }

    /**
     * 根据任意键获取用户
     */
    @Test
    public void getUserByName() {
        System.out.println(gson.toJson(userMapper.getByName("sy23")));
    }

    /**
     * 根据时间范围获取用户
     */
    @Test
    public void getByCreateTime() {
        System.out.println(gson.toJson(userMapper.getByCreateTime("2020-01-01 00:00:00")));
    }

    /**
     * 获取商品
     */
    @Test
    public void getGoodsById() {
        System.out.println(gson.toJson(goodsMapper.getById(3L)));
    }


}
