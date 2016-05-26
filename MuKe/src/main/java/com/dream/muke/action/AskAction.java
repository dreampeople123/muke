package com.dream.muke.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.service.AskService;

@Controller("askAction")
public class AskAction{
	@Autowired
	private AskService askService;
	
	public String getAskInfo(){
		askService.getAskInfo();
		return "getAskInfo";
	}
}
