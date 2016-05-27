package com.dream.muke.mapper;

import com.dream.muke.entity.Answer;

/**
 * 问题表映射接口
 * @author dream
 *
 */
public interface AnswerMapper {
	/**
	 * 获取问题下的回答
	 * @param getaNo
	 * @return
	 */
	public Answer getAskAnswerByNo(String aNo);
}