package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Course;
import com.dream.muke.mapper.UsersMapper;
import com.dream.muke.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	public List<Course> getTeacherCourse(String uNo) {
		return usersMapper.getTeacherCourse(uNo);
	}

}
