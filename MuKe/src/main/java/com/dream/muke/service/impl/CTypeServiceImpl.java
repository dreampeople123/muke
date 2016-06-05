package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.CType;
import com.dream.muke.mapper.CTypeMapper;
import com.dream.muke.service.CTypeService;

@Service("cTypeService")
public class CTypeServiceImpl implements CTypeService {
	@Autowired
	private CTypeMapper cTypeMapper;

	public List<CType> findAllCourseType() {
		return cTypeMapper.findAllCourseType();
	}

	public List<CType> findAllDir() {
		return cTypeMapper.findAllDir();
	}

	public List<CType> findTypeByDir(String key) {
		return cTypeMapper.findTypeByDir(key);
	}

}
