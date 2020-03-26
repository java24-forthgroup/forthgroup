package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Queue;
import com.woniuxy.pojo.Source;
import com.woniuxy.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/26 18:23:29
 */
@Controller
@RequestMapping("source")
public class SourceController {

    @Autowired
    SourceService sourceService;

    @RequestMapping("index")
    public  String index(){
        return  "source/index";
    }

    //查询所有号源池信息
    @RequestMapping("queryByPage")
    @ResponseBody
    public Object queryByPage(PageBean pageBean) {
        Message message =new Message();
        try {
            //第一次进来，PageBean为空，设置当前页为第一页。
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            pageBean.setPageRow(2);
            List<Source> sourceList = sourceService.queryByPage(pageBean);
            System.out.println(sourceList);
            System.out.println(pageBean);
            int countRow = sourceService.countByPage(pageBean);
            pageBean.setCountRow(countRow);
            pageBean.setCountPage(countRow%pageBean.getPageRow()==0?countRow/pageBean.getPageRow():countRow/pageBean.getPageRow()+1);
            pageBean.setList(sourceList);
            message.setObj(pageBean);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;

    }


}
