package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.CourseBean;

/**
 * 课程表映射接口
 * @author dream
 *
 */
public interface CourseMapper {

	List<Course> getCourseNameAndId();

	//查看所有课程信息
	List<CourseBean> getCourseInfo(Map<String, Object> map);
	
	//按照课程名或课程类别编号查找课程信息
	List<CourseBean> getCourseByInfo(Map<String, Object> map);

	//修改课程信息
	int updateCourseInfo(Map<String, Object> map);

	/**
	 * 前台部分
	 */
	//根据课程名查询课程信息
	List<CourseBean> getCourseByCname(Map<String, Object> map);

	//根据课程编号查询课程具体信息
	List<CourseBean> showCoursesByCno(Map<String, Object> map);

	//根据课程方向查找课程信息
	List<CourseBean> getCourseByCdirname(Map<String, Object> map);

	//根据课程类型名查找课程信息
	List<CourseBean> getCourseByCtname(Map<String, Object> map);

	//根据课程难易度查找课程信息
	List<CourseBean> getCourseByDname(Map<String, Object> map);
}