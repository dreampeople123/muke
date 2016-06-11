package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.Deeply;
import com.dream.muke.service.CTypeService;
import com.dream.muke.service.ChapterService;
import com.dream.muke.service.CourseService;
import com.dream.muke.service.DeeplyService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("coursesAction")
public class CoursesAction implements ModelDriven<CourseBean>,SessionAware{
	private CourseBean courseBean;
	private List<CourseBean> coursesInfo;
	@Autowired
	private CourseService courseService;
	@Autowired
	private CTypeService cTypeService;
	@Autowired
	private DeeplyService deeplyService;
	@Autowired
	private ChapterService chapterService;
	private int page;//进行分页的page
	private int rows;//进行分页的rows
	private Map<String,Object> map;
	
	private List<CourseBean> courses;
	
	public List<CourseBean> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}
	//增修返回值
	private int status;
	private Map<String, Object> session;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public List<CourseBean> getCoursesInfo() {
		return coursesInfo;
	}
	public void setCoursesInfo(List<CourseBean> coursesInfo) {
		this.coursesInfo = coursesInfo;
	}
	
	/**
	 * 后台部分
	 * @return
	 */
	
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
	
	/**
	 * 前台部分
	 */
	//根据课程名查找课程信息
	public String findCourseByCname(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("cName", courseBean.getcName());
		
		System.out.println(courseBean.getcName()+"传过来的课程名");
		coursesInfo = courseService.findCourseByCname(map);
		session.put("courseBean", coursesInfo);
		if(coursesInfo!=null){
			status=1;
		}else{
			status=0;
		}
		return "findCourseByCname";
	}
	
	//点击课程的时候,链接到course.jsp,显示所有的课程方向,类别,难易,和课程显示
	public String findAllTypes(){
		List<CType> cTypes = cTypeService.findAllCourseType();
		session.put("cTypeInfo", cTypes);
		List<Deeply> deeply = deeplyService.findAllDeeply();
		session.put("deeplyInfo", deeply);
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("page", page);
		map1.put("rows", rows);
		courses = courseService.findCourseInfo(map1);
		session.put("courseInfo", courses);
		System.out.println(courses+"课程信息");
		System.out.println("课程类别"+cTypes+"课程难易"+deeply);
		return "findAllTypes";
	}
	
	
	public String showCoursesByCno(){
		map = new HashMap<String, Object>();
		map.put("cNo", courseBean.getcNo());
		List<CourseBean> coursesInfo = courseService.showCoursesByCno(map);
		session.put("courseInfo", coursesInfo);
		List<Chapter> chapters = chapterService.findAllChapterByCno(map);
		session.put("chapterInfo", chapters);
		return "showCoursesByCno";
	}

	@Override
	public CourseBean getModel() {
		courseBean = new CourseBean();
		return courseBean;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
}
