package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.service.CTypeService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("cTypeAction")
public class CTypeAction implements ModelDriven<CType>{
	private CType cType;
	@Autowired
	private CTypeService cTypeService;
	private int status;
	Map<String,Object> map;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	private List<CType> cTypes; //课程类别
	
	public List<CType> getcTypes() {
		return cTypes;
	}

	/**
	 * 找到所有的课程类别
	 * @return
	 */
	public String findAllCourseType(){
		cTypes = cTypeService.findAllCourseType();
		return "findAllCourseType";
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
	@Override
	public CType getModel() {
		cType = new CType();
		return cType;
	}
}
