package com.woniuxy.controller;

import com.woniuxy.pojo.*;
import com.woniuxy.service.SkillgroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("Skillgroup")
public class SkillgroupController {
    @Resource
    private SkillgroupService skillgroupService;

    @RequestMapping("index")
    public String index(){
        return "skillgroup/skillgroup";
    }

    @RequestMapping("gosave")
    public String gosave(){
        return "skillgroup/save";
    }

    @RequestMapping("goupdate")
    public String goupdate(Integer skillgroupId , Model model){
        Skillgroup skillgroup = skillgroupService.findOne(skillgroupId);
        System.out.println(skillgroup);
        model.addAttribute("skillgroup",skillgroup);
        return  "skillgroup/update";
    }

    //展示所有医技组信息
    @ResponseBody
    @RequestMapping("allSkillgroup")
    public Object allSkillgroup(PageBean<Skillgroup> pageBean){
        Message message = new Message();

        try{
            List<Skillgroup> list=skillgroupService.selectByPage(pageBean);
            pageBean.setList(list);
            //总行数
            int countRow=skillgroupService.countAll();
            pageBean.setCountRow(countRow);
            //总页数
            int countpage=pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countpage);

            message.setFlag(true);
        }catch (Exception e){
            message.setFlag(false);
        }
        message.setObj(pageBean);


        return message;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer skillgroupId) {
        Message message = new Message();
        try{
            skillgroupService.delete(skillgroupId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("deletes")
    @ResponseBody
    public Object deletes(Integer[] skillgroupId) {


        Message message = new Message();
        try{
            skillgroupService.deletes(skillgroupId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }



    @RequestMapping("save")
    @ResponseBody
    public Object save(Skillgroup skillgroup) {
        Message message = new Message();
        try{
            skillgroupService.save(skillgroup);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;
    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(Skillgroup skillgroup) {
        Message message = new Message();
        try{
            skillgroupService.update(skillgroup);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("findone")
    @ResponseBody
    public Skillgroup findOne(Integer skillgroupId) {
        Skillgroup s = skillgroupService.findOne(skillgroupId);
        System.out.println(s);
        return s;
    }
}

