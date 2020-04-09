package com.woniuxy.controller;

import com.woniuxy.pojo.Aroom;
import com.woniuxy.pojo.Croom;
import com.woniuxy.pojo.Message;
import com.woniuxy.pojo.PageBean;
import com.woniuxy.service.AroomService;
import com.woniuxy.service.CroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author AriesBn
 * @date: 2020年3月26日 下午5:05:27
 */
@Controller
@RequestMapping("croom")
public class CroomController {
	@Autowired
	CroomService croomService;
	@Autowired
	AroomService aroomService;
	
	//获得croomList并转到列表页面
	@RequestMapping("croomList")
	public String  croomList(Model model){
		List<Croom> croomList=croomService.findAll();
		model.addAttribute("croomList",croomList);
		return "/croom/croomList";
	}
	
	//添加诊室
	@RequestMapping("croomAdd")
	public String  croomAdd(Croom croom){
		croomService.save(croom);
		return "/croom/croomListByPage";
	}
	//添加诊室
	@RequestMapping("croomAddJsp")
	public String  croomAddJsp(Model model){
		List<Aroom> aroomList = aroomService.findAll();
		model.addAttribute("aroomList", aroomList);
		return "/croom/croomAdd";
	}
	
	
	//删除诊室
	@RequestMapping("croomDel")
	public String  croomDel(Integer croomId){
		croomService.delete(croomId);
		return "redirect:/croom/croomListByPage";
	}
	
	//获取修改的诊室信息并转到修改页面
	@RequestMapping("croomEdit")
	public String  croomEdit(Integer croomId,Model model){
		Croom croomEdit=croomService.findOne(croomId);
		model.addAttribute("croomEdit", croomEdit);
		List<Aroom> aroomList = aroomService.findAll();
		model.addAttribute("aroomList", aroomList);
		return "/croom/croomEdit";
	}
	
	//确定修改提交到数据库并跳转到List页面
	@RequestMapping("croomEditSubmit")
	public String  croomEditSubmit(Croom croom){
		croomService.update(croom);
		return "/croom/croomListByPage";
	}
	
	@RequestMapping("croomListByPage")
	public String croomListByPage(PageBean<Croom> pageBean,Model model){
		Message message = new Message();
		//第一次进来时，没有任何数据提交个pageBean对象，但是该对象已经实例化，这时参数为null
		if(pageBean.getNowPage()==null) {
			pageBean.setNowPage(1);
		}
		pageBean.setPageRow(5);

		//获得数据表中的所有用户信息
		List<Croom> croomList = croomService.selectByPage(pageBean);
		
		for (Croom croom : croomList) {
			System.out.println(croom+"---------------------------------------");
		}
		
		
		
		
		pageBean.setList(croomList);
		
		int countRow = croomService.countAll(pageBean);
		pageBean.setCountRow(countRow);
		
		int countPage = pageBean.getCountRow()%pageBean.getPageRow()==0?pageBean.getCountRow()/pageBean.getPageRow():pageBean.getCountRow()/pageBean.getPageRow()+1;
		pageBean.setCountPage(countPage);
		
		List<Aroom> aroomList = aroomService.findAll();
		
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("aroomList", aroomList);
		
		
		return "croom/croomListByPage";
	}

}

