package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.Answer;
import com.dream.muke.mapper.AnswerMapper;
import com.dream.muke.service.AnswerService;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	public List<Answer> getAskAnswerByNo(String aNo) {
		return answerMapper.getAskAnswerByNo(aNo);
	}

}
