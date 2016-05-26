package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.BackAskBean;
import com.dream.muke.mapper.AskMapper;
import com.dream.muke.service.AskService;

@Service("askService")
public class AskServiceImpl implements AskService {
	@Autowired
	private AskMapper askMapper;

	public List<BackAskBean> getAskInfo() {
		return askMapper.getAskInfo();
	}

}
