package com.dream.muke.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.BackAskBean;
import com.dream.muke.service.AskService;

@Controller("askAction")
public class AskAction{
	@Autowired
	private AskService askService;
	
	private List<BackAskBean> asks; //问答信息
	public List<BackAskBean> getAsks() {
		return asks;
	}

	/**
	 * 获取全部的问答信息
	 * @return
	 */
	public String getAskInfo(){
		asks=askService.getAskInfo();
		System.out.println(asks);
		return "getAskInfo";
	}
}
