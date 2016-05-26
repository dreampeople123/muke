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
	public List<BackAskBean> getAskInfo();
}