package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.UCourseBean;
import com.dream.muke.service.UcourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("ucourseAction")
@Scope("prototype")
public class UcourseAction implements ModelDriven<UCourseBean> {
	@Autowired
	private UcourseService ucourseService;
	private Map<String,Object> ucourses;//查询所返回的结果
	@Autowired
	private UCourseBean uCourseBean;
	private int ucourse_result;//修改返回的结果
	
	public int getUcourse_result() {
		return ucourse_result;
	}
	public Map<String, Object> getUcourses() {
		return ucourses;
	}
	/**
	 * 查询所有的用户课程信息
	 * @return
	 */
public String getUcourseInfo(){
	ucourses=new HashMap<String, Object>();
	ucourses.put("total", ucourseService.totalUcourse(uCourseBean));
	ucourses.put("rows", ucourseService.findUcourse(uCourseBean));
	return "ucourseInfo";
	
}
/**
 * 保存修改的信息
 * @return
 */
public String updateUcourseInfo(){
	ucourse_result=ucourseService.updateUcourseInfo(uCourseBean);
	return "ucourse_result";
	
}
/**
 * 模糊查询ucourse
 * @return
 */
public String findUcourseByInfo(){
	ucourses=new HashMap<String, Object>();
	uCourseBean.setPage("1");
	uCourseBean.setRows("10");
	ucourses.put("total", ucourseService.totalUcourse(uCourseBean));
	ucourses.put("rows", ucourseService.findUcourse(uCourseBean));
	return "ucourseInfo";
}
	@Override
	public UCourseBean getModel() {
		return uCourseBean;
	}
}
