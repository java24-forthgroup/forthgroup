package com.woniuxy.controller;

import com.woniuxy.pojo.*;
import com.woniuxy.service.QueueService;
import com.woniuxy.service.SkillgroupService;
import com.woniuxy.service.SourceService;
import com.woniuxy.service.SourcetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    SkillgroupService skillgroupService;
    @Autowired
    SourcetypeService sourcetypeService;

    @RequestMapping("sourceList")
    public  String index(){
        return  "source/sourceList";
    }
    //增加时将将医技组、队列信息，号源池类型相关转发至页面，直观的可以按照名称添加
    @RequestMapping("addUI")
    public String addUI(Model model) {
       //医技组集合
       List<Skillgroup> skillgroupList = skillgroupService.findAll();
       //号源池类型集合
       List<Sourcetype> sourcetypeList  = sourcetypeService.findAll();
       model.addAttribute("skillgroupList",skillgroupList);
       model.addAttribute("sourcetypeList",sourcetypeList);
       return "source/addSource";
    }
    //增加号源池信息
    @ResponseBody
    @RequestMapping("addSource")
    public Object addQueue(Source source) {
        Message message = new Message();
        try {
            sourceService.save(source);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //删除号源池信息
    @ResponseBody
    @RequestMapping("delete")
    public Object delete(Integer sourceId) {
        Message message = new Message();
        try {
            System.out.println("sss==========sss"+sourceId);
            sourceService.delete(sourceId);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    //批量删除号源池信息
    @ResponseBody
    @RequestMapping("deleteSources")
    public Object deleteSources(Integer[] sourceIds) {
        Message message = new Message();
        try {
            for(Integer sourceId:sourceIds){
                System.out.println("---------"+sourceId);
            }
            sourceService.deleteSources(sourceIds);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

    //查找要修改的号源池信息
    @RequestMapping("updateUI")
    public String updateUI(Model model, Integer sourceId) {
        Source source  = sourceService.findOne(sourceId);
        System.out.println("sssssssssssssss"+sourceId);
        //查询所有发送至页面
        List<Skillgroup> skillgroupList = skillgroupService.findAll();
        List<Sourcetype> sourcetypeList  = sourcetypeService.findAll();
        model.addAttribute("skillgroupList",skillgroupList);
        model.addAttribute("sourcetypeList",sourcetypeList);
        //号源池信息
        model.addAttribute("source", source);
        return "source/updateSource";
    }
    //修改号源池信息
    @ResponseBody
    @RequestMapping("updateSource")
    public Object updateSource(Source source) {
        Message message = new Message();
        try {
            sourceService.update(source);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
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
            pageBean.setPageRow(3);
            List<Source> sourceList = sourceService.queryByPage(pageBean);
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
