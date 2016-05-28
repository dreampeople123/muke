package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.BackAskBean;

public interface AskService {
	/**
	 * 获取问答信息(后台)
	 * @return
	 */
	public List<BackAskBean> getAskInfo(BackAskBean backAskBean);

	/**
	 * 根据类型找到问题信息
	 * @param typeNo
	 * @return
	 */
	public List<BackAskBean> findAskByType(BackAskBean backAskBean);

	/**
	 * 删除ask信息
	 * @param askNos
	 */
	public void delAskInfo(String askNos);

	/**
	 * 获取目前的问题的数量
	 * @param backAskBean
	 * @return
	 */
	public int getAskTotal(BackAskBean backAskBean);

}
