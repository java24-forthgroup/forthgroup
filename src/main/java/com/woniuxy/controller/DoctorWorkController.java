package com.woniuxy.controller;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.Queue;
import com.woniuxy.service.ApprecordService;
import com.woniuxy.service.AroomService;
import com.woniuxy.service.PatientService;
import com.woniuxy.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("apprecord")
public class DoctorWorkController {
    @Autowired
    ApprecordService apprecordService;
    @Autowired
    PatientService patientService;
    @Autowired
    QueueService queueService;
    @Autowired
    AroomService aroomService;

    @Autowired
    @Qualifier("rt")
    RedisTemplate redisTemplate;

    //使用redis  Set操作queue
    @RequestMapping("confirm")
    @ResponseBody
    public Object confirm(Integer apprecordId,Integer projectId){
        Message message = new Message();
        System.out.println("-----"+apprecordId);
        System.out.println("******"+projectId);
        try {
            //通过id得到预约记录
            Apprecord apprecord = apprecordService.findOne(apprecordId);
            //确认病人签到缴费完毕
            apprecord.setAttendStatus("是");
            apprecord.setCostStatus("是");
            //更新状态
            apprecordService.update(apprecord);
            //从数据库中得到科室名称   首先通过病人预约的医技项目拿到对应的医技组，然后通过医技组拿到科室
            List<Apprecord> appList = apprecordService.getAroomByProjectId(projectId);
            for (Apprecord app:appList) {
                if(app.getProjectId()==projectId&&app.getApprecordId()==apprecordId){
                    int aroomId = app.getAroom().getAroomId();
                    Queue queue = new Queue(1, 0, aroomId);
                    int QueueNum = 1;
                    //从redis缓存中查出所有的队列信息
                    Set<Queue> queueSet = redisTemplate.opsForZSet().range("queue", 0, -1);
                    //刚开始set集合为null  size为0
                    int queueId = queueSet.size() + 1;
                    //将存储在redis中的aroomId 存储在aIdSet中
                    Set<Integer> aIdSet = new HashSet<Integer>();
                    for (Queue q : queueSet) {
                        int aId = q.getAroomId();
                        if (!aIdSet.contains(aId)) {
                            aIdSet.add(aId);
                        }
                    }
                    //判断aroomId是否在aIdSet中，如果在的话，就给对应的QueueNum+1
                    //不存在的话QueueNum=1
                    if (aIdSet.contains(aroomId)) {
                        //根据预约信息  分配相应的队列编号
                        //该科室已经有患者排队
                        for (Queue q : queueSet) {
                            if (aroomId == q.getAroomId()) {
                                int Num = q.getQueueNum();
                                QueueNum = ++Num;
                            }
                        }
                    } else {
                        //根据预约信息  分配相应的队列编号
                        //该科室已经有患者排队
                        QueueNum = 1;
                    }
                    queue.setQueueId(queueId++);
                    queue.setAroomId(aroomId);
                    //根据aroomId拿到Aroom,供予页面显示
                    queue.setAroom(aroomService.findOne(aroomId));
                    queue.setPatient(app.getPatient());
                    queue.setQueueNum(QueueNum);
                    //将队列信息存储在redis缓存中
                    redisTemplate.opsForZSet().add("queue", queue, queue.getQueueId());
                    redisTemplate.expire("queue", 12, TimeUnit.HOURS);
                }
            }
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
//    //使用redis  List操作queue   有问题
//    @RequestMapping("confirm")
//    @ResponseBody
//    public Object confirm(Integer apprecordId){
//        //通过id得到预约记录
//        Apprecord apprecord = apprecordService.findOne(apprecordId);
//        //确认病人签到缴费完毕
//        apprecord.setAttendStatus("是");
//        apprecord.setCostStatus("是");
//        apprecordService.update(apprecord);
//        Message message = new Message();
//        try {
//            //从数据库中得到科室名称   首先通过病人预约的医技项目拿到对应的医技组，然后通过医技组拿到科室
//            Apprecord app = apprecordService.getAroomByProjectId(apprecord.getProjectId());
//            int aroomId = app.getAroom().getAroomId();
//            Queue queue=new Queue(1,aroomId,1);
//            int aId = aroomId;
//            int QueueNum = 1;
//            //从redis缓存中查出所有的队列信息
//            List<Queue> list= redisTemplate.opsForList().range("queue",0,-1);
//            for (Queue q: list) {
//                aId = q.getAroomId();
//                if(aroomId==aId){
//                    //根据预约信息  分配相应的队列编号
//                    //该科室已经有患者排队
//                    int Num = q.getQueueNum();
//                    QueueNum = ++Num;
//                }else{
//                    //根据预约信息  分配相应的队列编号
//                    //该科室已经有患者排队
//                    QueueNum = 1;
//                }
//            }
//            queue.setQueueId(1);
//            queue.setAroomId(aId);
//            queue.setAroom(aroomService.findOne(aId));
//            queue.setQueueNum(QueueNum);
//            //将队列信息存储在redis缓存中
//            redisTemplate.opsForList().rightPush("queue",queue);
//            redisTemplate.expire("queue",12, TimeUnit.HOURS);
//            message.setFlag(true);
//        }catch(Exception e) {
//            e.printStackTrace();
//            message.setFlag(false);
//        }
//        return message;
//    }

//    @RequestMapping("confirm")
//    @ResponseBody
//    public Object confirm(Integer apprecordId){
//        //通过id得到预约记录
//        Apprecord apprecord = apprecordService.findOne(apprecordId);
//        //确认病人签到缴费完毕
//        apprecord.setAttendStatus("是");
//        apprecord.setCostStatus("是");
//        apprecordService.update(apprecord);
//        Message message = new Message();
//        try {
//            //查出所有的队列信息
//            List<Queue> queueList= queueService.findAll();
//            //得到科室名称   首先通过病人预约的医技项目拿到对应的医技组，然后通过医技组拿到科室
//            Apprecord app = apprecordService.getAroomByProjectId(apprecord.getProjectId());
//            int QueueNum = 1;
//            for(Queue queue:queueList){
//                String Name = queue.getAroom().getAroomName();
//                String aroomName = app.getAroom().getAroomName();
//                if(aroomName.equals(Name)){
//                    //根据预约信息  分配相应的队列编号
//                    //该科室已经有患者排队
//                    int Num = queue.getQueueNum();
//                    QueueNum = ++Num;
//                }else{
//                    //根据预约信息  分配相应的队列编号
//                    //该科室已经有患者排队
//                    QueueNum = 1;
//                }
//            }
//                Map<String,Object> map = new HashMap<String,Object>();
//                map.put("QueueNum",QueueNum);
//                map.put("aroomId",app.getAroom().getAroomId());
//                apprecordService.setPatientQueueNum(map);
//
//            message.setFlag(true);
//        }catch(Exception e) {
//            e.printStackTrace();
//            message.setFlag(false);
//        }
//        return message;
//    }

    //病人未签到
    @RequestMapping("unconfirm")
    @ResponseBody
    public Object unconfirm(Integer apprecordId){
        Message message = new Message();
        try {
            //通过id得到预约记录
            Apprecord apprecord = apprecordService.findOne(apprecordId);
            //确认病人签到缴费完毕
            apprecord.setAttendStatus("否");
            apprecord.setCostStatus("否");
            apprecordService.update(apprecord);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
}
