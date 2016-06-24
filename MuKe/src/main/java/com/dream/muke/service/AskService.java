package com.dream.muke.service;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Ask;
import com.dream.muke.entity.BackAskBean;
import com.dream.muke.entity.frontAsk;

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
	 * 查询视频界面的全部问答信息
	 * @param cno
	 * @return
	 */
	public List<frontAsk> findForntAsk(Map<String, Object> maps);
	/**
	 * 查询视频界面的精华问答信息
	 * @param cno
	 * @return
	 */
	public List<frontAsk> findJinAskByCtype(Map<String, Object> maps);
	/**
	 * 视频界面添加问答信息
	 * @param ask
	 * @return
	 */
	public int addAsk(Ask ask);
}
