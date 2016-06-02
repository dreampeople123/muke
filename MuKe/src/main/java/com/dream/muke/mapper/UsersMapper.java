package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.UsersBean;

/**
 * 用户映射接口
 * @author dream
 *
 */
@Repository("usersMapper")
public interface UsersMapper {
	/**
	 * 查询users的信息到usersBean
	 * @param usersBean
	 * @return
	 */
	public List<UsersBean> findUsers(UsersBean usersBean);
	/**
	 * 总记录数
	 * @return
	 */
	public int total(Map<String,Object> map);
	/**
	 * 批量删除用户数据
	 * @param uNos
	 * @return
	 */
	public int delUsers(String[] uNos);
	/**
	 * 更新用户数据
	 * @param usersBean
	 * @return
	 */
	public int updateUsers(UsersBean usersBean);
	/**
	 * 用户注册
	 * @return
	 */
	public int addUsreInfo(UsersBean usersBean);

}