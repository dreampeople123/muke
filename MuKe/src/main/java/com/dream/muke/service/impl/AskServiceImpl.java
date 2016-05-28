package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.muke.entity.BackAskBean;
import com.dream.muke.mapper.AnswerMapper;
import com.dream.muke.mapper.AskMapper;
import com.dream.muke.service.AskService;

@Service("askService")
public class AskServiceImpl implements AskService {
	@Autowired
	private AskMapper askMapper;
	@Autowired
	private AnswerMapper answerMapper;

	public List<BackAskBean> getAskInfo(BackAskBean backAskBean) {
		return askMapper.getAskInfo(backAskBean);
	}

	public List<BackAskBean> findAskByType(BackAskBean backAskBean) {
		return askMapper.findAskByType(backAskBean);
	}

	@Transactional
	public void delAskInfo(String askNos) {
		String[] as=askNos.split(",");
		for (String a : as) {
			//1.先将该问题的所有回答状态改为1
			delAskAnswerByANo(a);
			//2.再将该问题的状态改为1
			delAskInfoByNo(a);
		}
	}
	
	/**
	 * 根据编号删除ask信息
	 * @param aNo
	 */
	@Transactional
	public void delAskInfoByNo(String aNo){
		askMapper.delAskInfoByNo(aNo);
	}
	
	/**
	 * 根据问题编号删除问题下的回答信息
	 * @param aNo
	 */
	@Transactional
	public void delAskAnswerByANo(String aNo){
		answerMapper.delAskAnswerByANo(aNo);
	}

	public int getAskTotal(BackAskBean backAskBean) {
		return askMapper.getAskTotal(backAskBean);
	}
}
