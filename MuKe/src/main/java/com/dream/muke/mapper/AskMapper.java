package com.dream.muke.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.BackAskBean;

/**
 * 回答表映射接口
 * @author dream
 *
 */
@Repository("askMapper")
public interface AskMapper {
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
	 * 根据编号删除ask信息
	 * @param aNo
	 */
	public void delAskInfoByNo(String aNo);

	/**
	 * 获取当前的问题的数量
	 * @param backAskBean
	 * @return
	 */
	public int getAskTotal(BackAskBean backAskBean);
}