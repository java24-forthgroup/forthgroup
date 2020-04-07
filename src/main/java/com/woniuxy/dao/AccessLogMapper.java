package com.woniuxy.dao;

import com.woniuxy.pojo.AccessLog;
import com.woniuxy.pojo.PageBean;

import java.util.List;

/**
 * @author zhao
 * @create 2020/04/2020/4/2 10:23:48
 */
public interface AccessLogMapper {

    List<AccessLog> queryByPage(PageBean pageBean);
    int countByPage(PageBean pageBean);
    void  save(AccessLog accessLog);
    void delete(Integer logid);
    void deletelogs(Integer[] logids);
}
