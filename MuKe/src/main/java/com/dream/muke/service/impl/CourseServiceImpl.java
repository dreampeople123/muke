package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.mapper.CourseMapper;
import com.dream.muke.service.CourseService;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Override
	public List<Course> findCourseNameAndId() {
		
		return courseMapper.getCourseNameAndId();
	}
	@Override
	public List<CourseBean> findCourseInfo(Map<String, Object> map) {
		return courseMapper.getCourseInfo(map);
	}
	
	//按照课程名或课程类别编号查找课程信息
	@Override
	public List<CourseBean> findCourseByInfo(Map<String, Object> map) {
		return courseMapper.getCourseByInfo(map);
	}
	//修改课程信息
	@Override
	public int updateCourseInfo(Map<String, Object> map) {
		return courseMapper.updateCourseInfo(map);
	}
	
	/**
	 * 前台部分
	 */
	//通过课程名字查找课程信息
	@Override
	public List<CourseBean> findCourseByCname(Map<String, Object> map) {
		return courseMapper.getCourseByCname(map);
	}
	
	//根据课程编号查询课程具体信息
	@Override
	public List<CourseBean> showCoursesByCno(Map<String, Object> map) {
		return courseMapper.showCoursesByCno(map);
	}
	
	//根据课程方向查找课程信息
	@Override
	public List<CourseBean> findCourseByCdirname(Map<String, Object> map) {
		return courseMapper.getCourseByCdirname(map);
	}
	
	//根据课程类型名查找课程信息
	@Override
	public List<CourseBean> findCourseByCtname(Map<String, Object> map) {
		return courseMapper.getCourseByCtname(map);
	}
	
	//根据课程难易度查找课程信息
	@Override
	public List<CourseBean> findCourseByDname(Map<String, Object> map) {
		return courseMapper.getCourseByDname(map);
	}

}
