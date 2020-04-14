package com.woniuxy.dao;

import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Queue;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/25 21:40:25
 */
public interface QueueMapper {

    List<Queue> findAll();

    List<Queue> queryByPage(PageBean pageBean);

    int countByPage(PageBean pageBean);

    Queue findOne(Integer queueId);

    void save(Queue queue);

    void delete(Integer queueId);

    void update(Queue queue);

}
