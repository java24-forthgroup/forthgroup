package com.woniuxy.controller;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Queue;
import com.woniuxy.service.AroomService;
import com.woniuxy.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhao
 * @create 2020/03/2020/3/25 21:36:29
 */
@Controller
@RequestMapping("queue")
public class QueueController {
    @Autowired
    QueueService queueService;
    @Autowired
    AroomService aroomService;

    @RequestMapping("queueList")
    public String teacherList() {
        return "queue/queueList";
    }

    @RequestMapping("addUI")
    public String addUI(Model model) {
        List<Aroom> aroomList = aroomService.findAll();
        model.addAttribute("aroomList",aroomList);
        return "queue/addQueue";
    }

    //增加队列信息
    @ResponseBody
    @RequestMapping("addQueue")
    public Object addQueue(Queue queue) {
        System.out.println(queue);
        Message message = new Message();
        try {
            System.out.println(queue);
            queueService.save(queue);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //删除队列信息
    @ResponseBody
    @RequestMapping("delete")
    public Object delete(Integer queueId) {
        Message message = new Message();
        try {
            queueService.delete(queueId);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    //查找要修改的队列信息
    @RequestMapping("updateUI")
    public String updateUI(Model model, Integer queueId) {
        Queue queue  = queueService.findOne(queueId);
        System.out.println("==============="+queue);
        List<Aroom> aroomList = aroomService.findAll();
        model.addAttribute("aroomList",aroomList);
        model.addAttribute("queue", queue);
        return "queue/updateQueue";
    }
    //修改队列信息
    @ResponseBody
    @RequestMapping("updateQueue")
    public Object updateQueue(Queue queue) {
        Message message = new Message();
        try {
            queueService.update(queue);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //查询所有队列信息
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
            List<Queue> classRoomList = queueService.queryByPage(pageBean);
            System.out.println(classRoomList);
            System.out.println(pageBean);
            int countRow = queueService.countByPage(pageBean);
            pageBean.setCountRow(countRow);
            pageBean.setCountPage(countRow%pageBean.getPageRow()==0?countRow/pageBean.getPageRow():countRow/pageBean.getPageRow()+1);
            pageBean.setList(classRoomList);
            message.setObj(pageBean);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;

    }


}
