package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.CType;

public interface CTypeService {
	/**
	 * 找到所有的课程类型
	 * @return
	 */
	public List<CType> findAllCourseType();
}
