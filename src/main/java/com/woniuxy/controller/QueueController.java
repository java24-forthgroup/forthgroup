package com.woniuxy.controller;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Queue;
import com.woniuxy.service.AroomService;
import com.woniuxy.service.PatientService;
import com.woniuxy.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    @Autowired
    @Qualifier("rt")
    RedisTemplate redisTemplate;

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
            //数据库删除
            //queueService.delete(queueId);
            //redis删除
            redisTemplate.opsForZSet().removeRangeByScore("queue",queueId,queueId);
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
        Set<Queue> queueSet = null;
        int removeCount = 0;
        try {
            //第一次进来，PageBean为空，设置当前页为第一页。
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            queueSet= redisTemplate.opsForZSet().rangeByScore("queue",(pageBean.getNowPage()-1)*pageBean.getPageRow()+1,pageBean.getNowPage()*pageBean.getPageRow());
            //使用迭代器遍历redis中的queue集合，
            //开始使用foreach遍历set   使用set中remove方法 报错ConcurrentModificationException
            Iterator<Queue> it = queueSet.iterator();
            while(it.hasNext()){
                Queue q = it.next();
                //添加判断条件
                if(!q.getAroom().getAroomName().equals(pageBean.getQueryVal()) && pageBean.getQueryVal()!=null && !pageBean.getQueryVal().equals("")){
                    it.remove();
                    removeCount++;
                }
            }
            //队列总数   将long 转换为int
            int countRow =redisTemplate.opsForZSet().zCard("queue").intValue()-removeCount;
            pageBean.setCountRow(countRow);
            pageBean.setCountPage(countRow%pageBean.getPageRow()==0?countRow/pageBean.getPageRow():countRow/pageBean.getPageRow()+1);
            pageBean.setSet(queueSet);
            message.setObj(pageBean);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    //确认到诊   检查通过
    @ResponseBody
    @RequestMapping("accept")
    public Object accept(Queue queue) {
        Message message = new Message();
        try {
            //确认到诊   检查通过
            queueService.confirmaccept(queue);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    //确认未到诊 或者检查不通过
    @ResponseBody
    @RequestMapping("reject")
    public Object reject(Queue queue) {
        Message message = new Message();
        try {
            //确认未到诊 或者检查不通过
            queueService.confirmreject(queue);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

}
