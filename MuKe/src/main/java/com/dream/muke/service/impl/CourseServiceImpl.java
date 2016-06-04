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

}
