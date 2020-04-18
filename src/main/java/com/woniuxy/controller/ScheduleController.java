package com.woniuxy.controller;

import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Schedule;
import com.woniuxy.pojo.Skillgroup;
import com.woniuxy.service.ScheduleService;
import com.woniuxy.service.SkillgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/31   19:38
 */
@Controller
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    SkillgroupService skillgroupService;
    @RequestMapping("index")
    public String index(){
        return "schedule/index";
    }
    @RequestMapping("goSave")
    public String save(Model model){
        List<Skillgroup> skillgroupList = skillgroupService.findAll();
        model.addAttribute("skillgroupList",skillgroupList);
        return "schedule/save";
    }
    @RequestMapping("goUpdate")
    public String goUpdate(Model model,Integer scheduleId){
        List<Skillgroup> skillgroupList = skillgroupService.findAll();
        model.addAttribute("skillgroupList",skillgroupList);
        Schedule schedule = scheduleService.findOne(scheduleId);
        model.addAttribute("schedule",schedule);
        return "schedule/update";
    }
    @RequestMapping("findAllByPage")
    @ResponseBody
    public Message findAllByPage(PageBean pageBean){
        Message message = new Message();
        try {
            if(pageBean.getCountRow()==null){
                pageBean.setCountPage(1);
            }
            pageBean.setPageRow(5);
            int CountRow = scheduleService.countAll(pageBean);

            pageBean.setCountRow(CountRow);

            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);
            List<Schedule> scheduleList = scheduleService.findAllByPage(pageBean);
            pageBean.setList(scheduleList);
            message.setObj(pageBean);
            message.setFlag(true);

        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("delete")
    @ResponseBody
    public Message delete(Integer scheduleId){
        Message message = new Message();
        try {
            scheduleService.delete(scheduleId);
            message.setFlag(true);

        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("save")
    @ResponseBody
    public Message save(Schedule schedule){
        Message message = new Message();
        try {
            System.out.println(schedule);
            scheduleService.save(schedule);
            message.setFlag(true);

        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("update")
    @ResponseBody
    public Message update(Schedule schedule){
        Message message = new Message();
        try {
            System.out.println(schedule);
            scheduleService.update(schedule);
            message.setFlag(true);

        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("queryByDate")
    @ResponseBody
    public List<Schedule> queryByDate(String bookTime){
        List<Schedule> scheduleList= null;
        try {
            scheduleList = scheduleService.queryByDate(bookTime);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return scheduleList;
    }
    @RequestMapping("queryDatedBySkillgroup")
    @ResponseBody
    public Message queryDatedBySkillgroup(Schedule schedule){
        Message message = new Message();
        System.out.println(schedule+"1234564752");
        try {
             schedule = scheduleService.queryDatedBySkillgroup(schedule);

            message.setFlag(true);
            message.setObj(schedule);
        } catch (Exception e) {
            message.setFlag(false);
            e.printStackTrace();
        }

        return message;
    }

}
