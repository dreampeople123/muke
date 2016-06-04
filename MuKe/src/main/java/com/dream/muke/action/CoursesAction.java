package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CourseBean;
import com.dream.muke.service.CourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("coursesAction")
public class CoursesAction implements ModelDriven<CourseBean>{
	private CourseBean courseBean;
	private List<CourseBean> coursesInfo;
	@Autowired
	private CourseService courseService;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	private Map<String,Object> map;
	//增修返回值
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public List<CourseBean> getCoursesInfo() {
		return coursesInfo;
	}
	public void setCoursesInfo(List<CourseBean> coursesInfo) {
		this.coursesInfo = coursesInfo;
	}
	
	//查找所有课程信息
	public String findCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		coursesInfo = courseService.findCourseInfo(map);
		return "findCourseInfo";
	}
	
	//按照课程名或课程类别编号查找课程信息
	public String findCourseByInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("cName", courseBean.getcName());
		map.put("ctNo", Integer.parseInt(courseBean.getCtNo()));
		
		System.out.println(courseBean.getcName()+"传过来的类别名");
		System.out.println(Integer.parseInt(courseBean.getCtNo())+"闯过来的类别id");
		coursesInfo = courseService.findCourseByInfo(map);
		return "findCourseByInfo";
	}
	
	//修改课程信息
	public String updateCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("cNo", courseBean.getcNo());
		map.put("cName", courseBean.getcName());
		map.put("cUpstatus", courseBean.getcUpstatus());
		map.put("cStatus", courseBean.getcStatus());
		
		status = courseService.updateCourseInfo(map);
		return "updateCourseInfo";
	}

	@Override
	public CourseBean getModel() {
		courseBean = new CourseBean();
		return courseBean;
	}
}
