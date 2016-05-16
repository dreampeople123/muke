package com.dream.muke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Admin;
import com.dream.muke.mapper.AdminMapper;
import com.dream.muke.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public Admin adminLogin(Admin admin) {
		return adminMapper.adminLogin(admin);
	}

}
