package com.woniuxy.controller;

import com.woniuxy.pojo.Equipment;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("Equipment")
public class EquipmentController {
    @Resource
    private EquipmentService equipmentService;

    @RequestMapping("index")
    public String index(){
        return "equipment/equipment";
    }

    @RequestMapping("gosave")
    public String gosave(){
        return "equipment/save";
    }

    @RequestMapping("goupdate")
    public String goupdate(Integer equipmentId , Model model){
        Equipment equipment = equipmentService.findOne(equipmentId);
        model.addAttribute("equipment",equipment);
        return  "equipment/update";
    }


    //展示所有设备信息
    @ResponseBody
    @RequestMapping("allEquipment")
    public Object allEquipment(PageBean<Equipment> pageBean){
       Message message = new Message();

       try{
           List<Equipment> list=equipmentService.selectByPage(pageBean);
           pageBean.setList(list);
           //总行数
           int countRow=equipmentService.countAll();
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
    public Object delete(Integer equipmentId) {
        Message message = new Message();
        try{
            equipmentService.delete(equipmentId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("deletes")
    @ResponseBody
    public Object deletes(Integer[] equipmentId) {


        Message message = new Message();
        try{
            equipmentService.deletes(equipmentId);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @ResponseBody
    @RequestMapping("save")
    public Object save(Equipment equipment) {
        Message message = new Message();
        try{
            equipmentService.save(equipment);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(Equipment equipment) {
        Message message = new Message();
        try{
            equipmentService.update(equipment);
            message.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            message.setFlag(false);
        }

        return message;

    }

    @RequestMapping("findone")
    @ResponseBody
    public Equipment findOne(Integer equipmentId) {
        Equipment e=  equipmentService.findOne(equipmentId);
        System.out.println(e);
        return e;

    }



}
