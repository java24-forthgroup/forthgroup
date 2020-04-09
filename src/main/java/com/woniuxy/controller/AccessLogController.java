package com.woniuxy.controller;

import com.woniuxy.pojo.AccessLog;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.AccesslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhao
 * @create 2020/04/2020/4/2 09:59:26
 */
@Controller
@RequestMapping("accesslog")
public class AccessLogController {

    @Autowired
    AccesslogService accesslogService;

    @RequestMapping("index")
    public  String index(){
        return  "accesslog/index";
    }

    //删除日志信息
    @ResponseBody
    @RequestMapping("delete")
    public Object delete(Integer logid) {
        Message message = new Message();
        try {
            accesslogService.delete(logid);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //批量删除日志信息
    @ResponseBody
    @RequestMapping("deleteLogs")
    public Object deletelogs(Integer[] logids) {
        Message message = new Message();
        try {
           /* for(Integer logid:logids){
                System.out.println("---------"+logid);
            }*/
            accesslogService.deletelogs(logids);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }


    //查询所有日志池信息
    @RequestMapping("queryByPage")
    @ResponseBody
    public Object queryByPage(PageBean pageBean) {
        Message message = new Message();
        try {
            //第一次进来，PageBean为空，设置当前页为第一页。
            if (pageBean.getNowPage() == null) {
                pageBean.setNowPage(1);
            }
            pageBean.setPageRow(10);
            List<AccessLog> AccessLogList = accesslogService.queryByPage(pageBean);
            int countRow = accesslogService.countByPage(pageBean);
            pageBean.setCountRow(countRow);
            pageBean.setCountPage(countRow % pageBean.getPageRow() == 0 ? countRow / pageBean.getPageRow() : countRow / pageBean.getPageRow() + 1);
            pageBean.setList(AccessLogList);
            message.setObj(pageBean);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;

    }
}
