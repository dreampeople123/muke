package com.dream.muke.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Admin;
import com.dream.muke.service.AdminService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction implements ModelDriven<Admin> {
	@Autowired
	private AdminService adminService;
	private List<Admin> admins;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	@Autowired
	private Admin admin;//进行增删改的临时的admin
	private int admin_result;//进行增删改的的结果int类型

	public int getAdmin_result() {
		return admin_result;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public List<Admin> getAdmins() {
		return admins;
	}

	/**
	 * 查询所有管理员的信息
	 * @return
	 */
	public String info(){
		admins=adminService.findAllAdmin(Integer.parseInt(page),Integer.parseInt(rows));
		return "admininfo";
	}
	/**
	 * 添加管理员信息
	 * @return
	 */
	public String addAdminInfo(){
		admin_result=adminService.addAdmin(admin);
		return "admin_result";
	}
	/**
	 * 修改管理员信息
	 * @return
	 */
	public String updateAdminInfo(){
		admin_result=adminService.updateAdmin(admin);
		return "admin_result";
	}
	/**
	 * 删除管理员信息
	 * @return
	 */
	public String delAdminInfo(){
		String aId=admin.getaId();
		if(aId.contains(",") ){
			String[] aid=aId.split(",");
			for(int i=0;i<aid.length;i++){
				admin_result=adminService.delAdmin(aid[i]);
				if(admin_result!=1){
					return "admin_result";
				}
			}
			return "admin_result";
		}else{
			admin_result=adminService.delAdmin(aId);
			return "admin_result";
		}
	} 
	
	public Admin getModel() {
		return admin;
	}
}
