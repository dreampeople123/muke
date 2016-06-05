package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.Course;

public interface UsersService {
	/**
	 * 获取该教师维护的所有课程
	 * @param getuNo
	 * @return
	 */
	public List<Course> getTeacherCourse(String uNo);
	
/**
 * 查询users的信息
 * @param user：查询的用户信息
 * @param page：当前页
 * @param rows：
 * @return
 *//*
	List<Users> findUsers(Users user, int page, int rows);*/

}
