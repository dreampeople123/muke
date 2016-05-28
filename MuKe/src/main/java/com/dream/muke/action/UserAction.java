package com.dream.muke.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Users;
import com.dream.muke.service.UsersService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<Users> {
	@Autowired
	private UsersService usersService;
	private List<Users> users;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	private Users user;//增删改临时的users
	
	public void setPage(String page) {
		this.page = page;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public List<Users> getUsers() {
		return users;
	}

	/**
	 * 后台查询用户信息
	 * @return
	 */
	public String getPageUserInfo(){
		/*users=usersService.findUsers(user,Integer.parseInt(page),Integer.parseInt(rows));*/
		return "";
	}

	@Override
	public Users getModel() {
		return user;
	}
}
