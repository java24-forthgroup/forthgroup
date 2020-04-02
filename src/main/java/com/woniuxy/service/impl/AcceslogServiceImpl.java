package com.woniuxy.service.impl;

import com.woniuxy.dao.AccessLogMapper;
import com.woniuxy.pojo.AccessLog;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.AccesslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @create 2020/04/2020/4/2 10:03:29
 */
@Service
@Transactional
public class AcceslogServiceImpl implements AccesslogService {

   @Autowired(required = false)
    AccessLogMapper accessLogMapper;
    @Override
    public List<AccessLog> queryByPage(PageBean pageBean) {
        return accessLogMapper.queryByPage(pageBean);
    }

    @Override
    public int countByPage(PageBean pageBean) {
        return accessLogMapper.countByPage(pageBean);
    }

    @Override
    public void delete(Integer logid) {
        accessLogMapper.delete(logid);
    }

    @Override
    public void deletelogs(Integer[] logids) {
        accessLogMapper.deletelogs(logids);
    }
}
