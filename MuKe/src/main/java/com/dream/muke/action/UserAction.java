package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.UsersBean;
import com.dream.muke.service.UsersService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<UsersBean> {
	@Autowired
	private UsersService usersService;
	private Map<String, Object > users;
	@Autowired
	private UsersBean usersBean;//增删改查临时接收的usersBean	
	private int users_result;//进行删改的的结果int类型
	
	public int getUsers_result() {
		return users_result;
	}


	public Map<String, Object> getUsers() {
		return users;
	}
	/**
	 * 审核教师
	 * @return
	 */
	public String sehen(){
		users_result=usersService.updateUsers(usersBean);
		return "users_result";
	}
	/**
	 * 后台查询用户信息
	 * @return
	 */
	public String getPageUserInfo(){
		usersBean.setuIsTeacher(-1);//查询所有给-1
		Map<String,Object> totals=new HashMap<String,Object>();
		totals.put("uName", usersBean.getuName());
		totals.put("uIsTeacher", usersBean.getuIsTeacher());
		users = new HashMap<String, Object >();
		users.put("total", usersService.total(totals));
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	/**
	 * 查看详细的用户信息
	 * @return
	 */
	public String findNewsByUno(){
		usersBean.setuIsTeacher(-1);
		usersBean.setPage("1");
		usersBean.setRows("10");
		System.out.println("传进来"+usersBean);
		users = new HashMap<String, Object >();
		
		List<UsersBean> ress= usersService.findUsers(usersBean);
		System.out.println("结果是"+ress);
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	/**
	 * 删除用户信息
	 * @return
	 */
	public String delUserInfo(){
		String unos=usersBean.getuNo();
		String[] uNos=unos.split(",");
		users_result=usersService.delUsers(uNos);
		return "users_result";
	}
	/**
	 * 模糊查询用户信息
	 * @return
	 */
	public String findUsersInfoByInfo(){
		usersBean.setPage("1");
		usersBean.setRows("10");
		Map<String,Object> totals=new HashMap<String,Object>();
		totals.put("uName", usersBean.getuName());
		totals.put("uIsTeacher", usersBean.getuIsTeacher());
		users = new HashMap<String, Object >();
		users.put("total", usersService.total(totals));
		users.put("rows", usersService.findUsers(usersBean));
		return "usersInfo";
	}
	@Override
	public UsersBean getModel() {
		return usersBean;
	}
}
