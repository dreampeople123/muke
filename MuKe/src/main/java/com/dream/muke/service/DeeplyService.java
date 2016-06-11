package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Deeply;

public interface DeeplyService {
	//查找所有课程难易度
	List<Deeply> findAllDeeplyInfo(int page, int rows);

	int addDeeplyInfo(Map<String, Object> map);

	//修改课程难易程度信息
	int updateDeeplyInfo(Map<String, Object> map);

	//删除课程难易程度信息
	int delDeeplyInfo(Map<String, Object> map);

	//查找所有难易度信息
	List<Deeply> findAllDeeply();

}
