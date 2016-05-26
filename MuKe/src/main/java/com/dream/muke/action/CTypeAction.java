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
	
	private List<CType> cTypes; //课程类别
	
	public List<CType> getcTypes() {
		return cTypes;
	}

	/**
	 * 找到所有的课程类别
	 * @return
	 */
	public String findAllCourseType(){
		cTypes=cTypeService.findAllCourseType();
		return "findAllCourseType";
	}
}
