package com.woniuxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.AroomService;

/**
 * @author AriesBn
 * @date: 2020年3月26日 下午4:59:09
 */
@Controller
@RequestMapping("aroom")
public class AroomController {
	@Autowired
	AroomService aroomService;
	
	//获得AroomList并转到列表页面
	@RequestMapping("aroomList")
	public String  aroomList(Model model){
//		List<Aroom> AroomList=aroomService.findAll();
//		model.addAttribute("AroomList",AroomList);
		return "/aroom/aroomListByPage";
	}
	
	//添加科室
	@RequestMapping("aroomAdd")
	@ResponseBody
	public String  aroomAdd(Aroom aroom){
		aroomService.save(aroom);
		return "/aroom/aroomListByPage";
	}
	
	//删除科室
	@RequestMapping("aroomDel")
	public String  AroomDel(Integer aroomId){
		aroomService.delete(aroomId);
		return "redirect:/aroom/aroomListByPage";
	}
	
	//获取修改的科室信息并转到修改页面
	@RequestMapping("aroomEdit")
	public String  AroomEdit(Integer aroomId,Model model){
		Aroom aroomEdit=aroomService.findOne(aroomId);
		model.addAttribute("aroomEdit", aroomEdit);
		return "/aroom/aroomEdit";
	}
	
	//确定修改提交到数据库并跳转到List页面
	@RequestMapping("aroomEditSubmit")
	@ResponseBody
	public String  AroomEditSubmit(Aroom aroom){
		aroomService.update(aroom);
		return "/aroom/aroomListByPage";
	}
	
	@RequestMapping("aroomListByPage")
	public String AroomListByPage(PageBean<Aroom> pageBean,Model model){
		Message message = new Message();
			//第一次进来时，没有任何数据提交个pageBean对象，但是该对象已经实例化，这时参数为null
		if(pageBean.getNowPage()==null) {
			pageBean.setNowPage(1);
		}
		pageBean.setPageRow(5);

		//获得数据表中的所有用户信息
		List<Aroom> aroomList = aroomService.selectByPage(pageBean);
		for (Aroom aroom : aroomList) {
			System.out.println(aroom);
		}
		pageBean.setList(aroomList);
		
		int countRow = aroomService.countAll(pageBean);
		pageBean.setCountRow(countRow);
		
		int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
		pageBean.setCountPage(countPage);
			
		model.addAttribute("pageBean", pageBean);
		
		return "/aroom/aroomListByPage";
	}

}
