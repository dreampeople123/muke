package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.BackAskBean;

public interface AskService {
	/**
	 * 获取问答信息(后台)
	 * @return
	 */
	public List<BackAskBean> getAskInfo();

}
