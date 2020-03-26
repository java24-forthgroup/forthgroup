package com.woniuxy.controller;


import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.pojo.Sourcetype;
import com.woniuxy.service.SourcetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sourceType")
public class SourcetypeController {
    @Autowired
    SourcetypeService sourcetypeService;

    @RequestMapping("index")
    public String index(){
        return "sourceType/index";
    }
    @RequestMapping("goSave")
    public String goSave(){
        return "sourceType/save";
    }

    @RequestMapping("findAllByPage")
    @ResponseBody
    public Message findAllByPage(PageBean page){
        Message message = new Message();
        System.out.println(page);
        try {
            if(page.getNowPage()==null) {
                page.setNowPage(1);
            }
            page.setPageRow(5);
            int CountRow = sourcetypeService.countAll(page);
            System.out.println(CountRow);
            page.setCountRow(CountRow);

            int countPage = page.getCountRow()%page.getPageRow()==0?page.getCountRow()/page.getPageRow():page.getCountRow()/page.getPageRow()+1;
            page.setCountPage(countPage);

            List<Sourcetype> sourcetypeList=sourcetypeService.findAllByPageBean(page);

            page.setList(sourcetypeList);
            message.setObj(page);
            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @RequestMapping("findOne")
    public String findOne(Model mode , Integer typeId){
        Message message = new Message();
        try {
            Sourcetype sourcetype =sourcetypeService.findOne(typeId);

            mode.addAttribute("sourcetype",sourcetype);
            return "sourceType/update";
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "sourceType/update";
    }

    @ResponseBody
    @RequestMapping("delSourcetypes")
    public Message delSourcetypes(Integer [] typeId){

        Message message = new Message();
        try {
            sourcetypeService.delSourcetypes(typeId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("delete")
    public Message delete(Integer typeId){

        Message message = new Message();
        try {
            sourcetypeService.delete(typeId);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("save")
    public Message save(Sourcetype sourcetype){
        Message message = new Message();
        try {
            sourcetypeService.save(sourcetype);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
    @ResponseBody
    @RequestMapping("update")
    public Message update(Sourcetype sourcetype){
        Message message = new Message();
        try {
            sourcetypeService.update(sourcetype);

            message.setFlag(true);
        }catch(Exception e) {
            e.printStackTrace();
            message.setFlag(false);
        }
        return message;
    }
}
