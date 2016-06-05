package com.dream.muke.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.CType;

/**
 * 课程类别表映射接口
 * @author dream
 *
 */
@Repository("cTypeMapper")
public interface CTypeMapper {
	/**
	 * 找到所有的课程类别
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