package com.dream.muke.mapper;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Admin;

/**
 * 管理员映射接口
 * @author Administrator
 *
 */
@Repository("adminMapper")
public interface AdminMapper {
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin adminLogin(Admin admin);
}
