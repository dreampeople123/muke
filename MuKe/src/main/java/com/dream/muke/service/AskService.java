package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.BackAskBean;
import com.dream.muke.entity.CommunityAskBean;

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
	
	/**
	 * 获取社区问答信息
	 * @param backAskBean
	 * @return
	 */
	public List<CommunityAskBean> findCommunityAsks(BackAskBean backAskBean);

	/**
	 * 获取社区的热门问答
	 */
	public List<CommunityAskBean> findCommunityHotAsk();

	/**
	 * 获取社区回答雷锋榜
	 * @return
	 */
	public List<CommunityAskBean> findCommunityHotUser();

	/**
	 * 根据编号找到问题
	 * @param askNos
	 */
	public CommunityAskBean findAskBeanByNo(String aNo);

	/**
	 * 添加问题信息
	 * @param params
	 * @return
	 */
	public int addAsk(Map<String, Object> params);
}
