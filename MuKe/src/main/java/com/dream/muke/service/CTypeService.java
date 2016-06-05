package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.CType;

public interface CTypeService {
	/**
	 * 找到所有的课程类型
	 * @return
	 */
	public List<CType> findAllCourseType();

	/**
	 * 找到所有的方向
	 * @return
	 */
	public List<CType> findAllDir();

	/**
	 * 根据方向找到所有的类别
	 * @param key
	 * @return
	 */
	public List<CType> findTypeByDir(String key);
}
