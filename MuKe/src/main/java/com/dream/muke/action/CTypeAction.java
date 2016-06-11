package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.service.CTypeService;
import com.dream.muke.service.CourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("cTypeAction")
public class CTypeAction implements ModelDriven<CType>,SessionAware{
	private CType cType;
	@Autowired
	private CTypeService cTypeService;
	@Autowired
	private CourseService courseService;
	private int status;
	Map<String,Object> map;
	List<CourseBean> courses;
	
	public List<CourseBean> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	private List<CType> cTypes; //课程类别
	private Map<String, Object> session;
	
	public List<CType> getcTypes() {
		return cTypes;
	}

	/**
	 * 找到所有的课程类别
	 * @return
	 */
	public String findAllCourseType(){
		cTypes = cTypeService.findAllCourseType();
		return "findAllCourseType";
	}

	//删除课程类别信息
	public String delCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		status = cTypeService.delCourseTypeInfo(map);
		return "delCourseTypeInfo";
	}
	
	//更改课程类别信息
	public String updateCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		map.put("ctDirname", cType.getCtDirname());
		map.put("ctName", cType.getCtName());
		map.put("ctStatus", cType.getCtStatus());
		status = cTypeService.updateCourseTypeInfo(map);
		return "updateCourseTypeInfo";
	}
	
	//添加课程类别信息
	public String addCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		map.put("ctDirname", cType.getCtDirname());
		map.put("ctName", cType.getCtName());
		map.put("ctStatus", cType.getCtStatus());
		status = cTypeService.addCourseTypeInfo(map);
		return "addCourseTypeInfo";
	}
	
	/**
	 * 前台部分
	 */
	//根据课程方向名查找课程信息
	public String findCourseByCdirname(){
		map = new HashMap<String, Object>();
		/*String ctDirname="";
		try {
			ctDirname=new String(cType.getCtDirname().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		map.put("ctDirname",cType.getCtDirname());
		System.out.println(cType.getCtDirname()+"方向名");
		courses = courseService.findCourseByCdirname(map);
		System.out.println(courses+"课程");
		//session.put("courseInfos", courses);
		
		return "findCourseByCdirname";
	}
	
	//根据课程类名查看课程信息
	public String showCourseByCtypename(){
		map = new HashMap<String, Object>();
		map.put("ctName", cType.getCtName());
		System.out.println(cType.getCtName());
		
		courses = courseService.findCourseByCtname(map);
		System.out.println(courses);
		
		return "showCourseByCtypename";
	}
	
	@Override
	public CType getModel() {
		cType = new CType();
		return cType;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
}
