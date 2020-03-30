package com.woniuxy.controller;

import com.woniuxy.pojo.Apprecord;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.ApprecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @auther: 秦浦华
 * @DATE: 2020/3/28   16:25
 */
@Controller
@RequestMapping("apprecord")
public class ApprecordController {
    @Autowired
    ApprecordService apprecordService;
    //查询全部
    @RequestMapping("index")
    public String index(){
        return "apprecord/index";
    }
    @RequestMapping("goSave")
    public String goSave(){
        return "apprecord/save";
    }
    @RequestMapping("findAllByPage")
    @ResponseBody
    public Message findAllByPage(PageBean pageBean){
        Message message = new Message();
        try {
            if(pageBean.getNowPage()==null) {
                pageBean.setNowPage(1);
            }
            pageBean.setPageRow(5);
            int CountRow = apprecordService.countAll(pageBean);

            pageBean.setCountRow(CountRow);

            int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
            pageBean.setCountPage(countPage);
            List<Apprecord> list= apprecordService.findAllByPage(pageBean);
            System.out.println(list);
            pageBean.setList(list);
            message.setObj(pageBean);
            message.setFlag(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
    @RequestMapping("findOne")
    public String findOne(Model mode , Integer apprecordId){
        Message message = new Message();
        try {
            Map map = apprecordService.findOne(apprecordId);

            mode.addAttribute("map",map);

            return "apprecord/update";
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "apprecord/update";
    }

    @ResponseBody
    @RequestMapping("delApprecords")
    public Message delApprecord(Integer [] typeId){

        Message message = new Message();
        try {
            apprecordService.delApprecords(typeId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("delete")
    public Message delete(Integer apprecordId){

        Message message = new Message();
        try {
            apprecordService.delete(apprecordId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("save")
    public Message save(Apprecord apprecord){
        Message message = new Message();
        try {
            apprecordService.save(apprecord);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("update")
    public Message update(Apprecord apprecord){
        Message message = new Message();

        try {
            apprecordService.update(apprecord);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }

}
