package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Deeply;
import com.dream.muke.mapper.DeeplyMapper;
import com.dream.muke.service.DeeplyService;

@Service("deeplyService")
public class DeeplyServiceImpl implements DeeplyService {
	@Autowired
	private DeeplyMapper deeplyMapper;

	public List<Deeply> getDeeply() {
		return deeplyMapper.getDeeply();
	}

}
