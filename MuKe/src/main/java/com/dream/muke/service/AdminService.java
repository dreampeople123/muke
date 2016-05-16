package com.dream.muke.service;

import com.dream.muke.entity.Admin;

public interface AdminService {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin adminLogin(Admin admin);
}
