package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.CourseBean;
@Repository
public interface CourseService {
	List<Course> findCourseNameAndId();

	//查找所有课程信息
	List<CourseBean> findCourseInfo(Map<String, Object> map);
	
	//按照课程名或课程类别编号查找课程信息
	List<CourseBean> findCourseByInfo(Map<String, Object> map);
	
	//修改课程信息
	int updateCourseInfo(Map<String, Object> map);

	/**
	 * 前台部分
	 */
	//通过课程名字查找课程信息
	List<CourseBean> findCourseByCname(Map<String, Object> map);

	//根据课程编号查询课程具体信息
	List<CourseBean> showCoursesByCno(Map<String, Object> map);

	//根据课程方向查找课程信息
	List<CourseBean> findCourseByCdirname(Map<String, Object> map);

	//根据课程类型名查找课程信息
	List<CourseBean> findCourseByCtname(Map<String, Object> map);

	//根据课程难易度查找课程信息
	List<CourseBean> findCourseByDname(Map<String, Object> map);
}
