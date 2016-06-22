package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.service.CTypeService;
import com.dream.muke.utils.SessionKey;
import com.opensymphony.xwork2.ModelDriven;

@Controller("cTypeAction")
public class CTypeAction implements ModelDriven<CType>,SessionAware{
	private Map<String, Object> session;
	private CType cType;
	@Autowired
	private CTypeService cTypeService;
	private int status;
	Map<String,Object> map;
	private List<CType> cTypes; //课程类别json
	
	private String key;
	

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public List<CType> getcTypes() {
		return cTypes;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 找到所有的课程类别
	 * @return
	 */
	public String findAllCourseType(){
		cTypes = cTypeService.findAllCourseType();
		session.put(SessionKey.ALLTYPES, cTypes);
		return "findAllCourseType";
	}
	
	/**
	 * 找到所有的方向
	 * @return
	 */
	public String findAllDir(){
		cTypes=cTypeService.findAllDir();
		return "findAllDir";
	}
	
	public String findTypeByDir(){
		cTypes=cTypeService.findTypeByDir(key);
		return "findTypeByDir";
	}

	//删除课程类别信息
	public String delCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		status = cTypeService.delCourseTypeInfo(map);
		return "delCourseTypeInfo";
	}
	
	//更改课程类别信息
	public String updateCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		map.put("ctDirname", cType.getCtDirname());
		map.put("ctName", cType.getCtName());
		map.put("ctStatus", cType.getCtStatus());
		status = cTypeService.updateCourseTypeInfo(map);
		return "updateCourseTypeInfo";
	}
	
	//添加课程类别信息
	public String addCourseTypeInfo(){
		map = new HashMap<String, Object>();
		map.put("ctNo", cType.getCtNo());
		map.put("ctDirname", cType.getCtDirname());
		map.put("ctName", cType.getCtName());
		map.put("ctStatus", cType.getCtStatus());
		status = cTypeService.addCourseTypeInfo(map);
		return "addCourseTypeInfo";
	}
	
	public CType getModel() {
		cType = new CType();
		return cType;
	}
}
