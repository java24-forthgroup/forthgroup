package com.woniuxy.service.impl;

import com.woniuxy.dao.QueueMapper;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Queue;
import com.woniuxy.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/25 21:41:46
 */
@Service
@Transactional
public class QueueServiceImpl implements QueueService {

    @Autowired(required = false)
    QueueMapper queueMapper;

    @Override
    public List<Queue> findAll() {
        return queueMapper.findAll();
    }

    @Override
    public List<Queue> queryByPage(PageBean pageBean) {

        return queueMapper.queryByPage(pageBean);
    }

    @Override
    public int countByPage(PageBean pageBean) {
        return queueMapper.countByPage(pageBean);
    }

    @Override
    public Queue findOne(Integer queueId) {

        return queueMapper.findOne(queueId);
    }

    @Override
    public void save(Queue queue) {

        queueMapper.save(queue);
    }

    @Override
    public void delete(Integer queueId) {
        queueMapper.delete(queueId);
    }

    @Override
    public void update(Queue queue) {
        queueMapper.update(queue);
    }

    @Override
    public void confirmaccept(Queue queue) {
        queue.setPatientStatus("正常");
        queueMapper.update(queue);
    }

    @Override
    public void confirmreject(Queue queue) {
        queue.setPatientStatus("不正常");
        queueMapper.update(queue);
    }
}
