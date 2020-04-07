package com.woniuxy.service;

import com.woniuxy.pojo.AccessLog;
import com.woniuxy.pojo.PageBean;

import java.util.List;

/**
 * @author zhao
 * @create 2020/04/2020/4/2 10:03:07
 */
public interface AccesslogService {

    List<AccessLog> queryByPage(PageBean pageBean);
    int countByPage(PageBean pageBean);
    void delete(Integer logid);
    void deletelogs(Integer[] logids);
}
