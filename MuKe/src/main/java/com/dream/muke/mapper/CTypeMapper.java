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
	
}