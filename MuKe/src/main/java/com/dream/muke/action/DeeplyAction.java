package com.dream.muke.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.service.DeeplyService;

/**
 * 难易度
 * @author Administrator
 *
 */
@Controller("deeplyAction")
public class DeeplyAction {
	@Autowired
	private DeeplyService deeplyService;
	
	private Map<String,Object> deeplys=new HashMap<String,Object>(); //json数据
	
	public Map<String, Object> getDeeplys() {
		return deeplys;
	}

	public String getDeeply(){
		deeplys.put("deeply", deeplyService.getDeeply());
		return "getDeeply";
	}
}
