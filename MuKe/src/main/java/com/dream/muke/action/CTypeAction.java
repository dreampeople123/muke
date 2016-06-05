package com.dream.muke.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CType;
import com.dream.muke.service.CTypeService;

@Controller("cTypeAction")
public class CTypeAction {
	@Autowired
	private CTypeService cTypeService;
	
	private String key;
	
	private List<CType> cTypes; //课程类别json
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
		cTypes=cTypeService.findAllCourseType();
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
}
