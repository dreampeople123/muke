package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.Deeply;

/**
 * 难易度
 * @author Administrator
 *
 */
public interface DeeplyService {
	/**
	 * 获取所有的难易度
	 * @return
	 */
	public List<Deeply> getDeeply();

}
