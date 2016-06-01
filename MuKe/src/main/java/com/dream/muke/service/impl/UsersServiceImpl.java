package com.dream.muke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.UsersBean;
import com.dream.muke.mapper.UsersMapper;
import com.dream.muke.service.UsersService;
@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	/**
	 * 查询users的信息到usersBean
	 * @param usersBean
	 * @return
	 */
	@Override
	public List<UsersBean> findUsers(UsersBean usersBean) {
		return usersMapper.findUsers(usersBean);
	}
	/**
	 * 总记录数
	 * @return
	 */
	@Override
	public int total(Map<String,Object> map) {
		return usersMapper.total(map);
	}
 	/**
	 * 批量删除用户数据
	 * @param uNos
	 * @return
	 */
	@Override
	public int delUsers(String[] uNos) {
		return usersMapper.delUsers(uNos);
	}
	/**
	 * 更新用户数据
	 * @param usersBean
	 * @return
	 */
	@Override
	public int updateUsers(UsersBean usersBean) {
		return usersMapper.updateUsers(usersBean);
	}
	

}
