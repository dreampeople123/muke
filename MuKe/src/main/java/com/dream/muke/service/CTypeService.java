package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.CType;

public interface CTypeService {
	/**
	 * 找到所有的课程类型
	 * @return
	 */
	public List<CType> findAllCourseType();

	//删除课程类别信息
	public int delCourseTypeInfo(Map<String, Object> map);

	//更改课程类别信息
	public int updateCourseTypeInfo(Map<String, Object> map);

	//添加课程类别信息
	public int addCourseTypeInfo(Map<String, Object> map);
}
