package com.dream.muke.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Ask;
import com.dream.muke.entity.BackAskBean;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.service.AskService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("askAction")
public class AskAction implements ModelDriven<BackAskBean>,SessionAware{
	private BackAskBean backAskBean;
	@Autowired
	private AskService askService;
	
	private Map<String,Object> asks=new HashMap<String, Object>(); //传到后台的json信息,问答信息
	private int result; //传到后台的数据更新结果
	private Map<String,Object> session;
	private String askNos; //问题编号
	public void setAskNos(String askNos) {
		this.askNos = askNos;
	}
	
	public Map<String,Object> getAsks() {
		return asks;
	}
	public int getResult() {
		return result;
	}

	public BackAskBean getModel() {
		backAskBean=new BackAskBean();
		return backAskBean;
	}

	/**
	 * 获取全部的问答信息
	 * @return
	 */
	public String getAskInfo(){
		asks.put("rows",askService.getAskInfo(backAskBean));
		asks.put("total", askService.getAskTotal(backAskBean));
		return "getAskInfo";
	}
	
	/**
	 * 根据类型找到问题信息
	 */
	public String findAskByType(){
		if("0".equals(backAskBean.getTypeNo())){
			backAskBean.setTypeNo(null);
			asks.put("rows",askService.getAskInfo(backAskBean));
			asks.put("total", askService.getAskTotal(backAskBean));
		} else{
			asks.put("rows",askService.findAskByType(backAskBean));
			asks.put("total", askService.getAskTotal(backAskBean));
		}
		return "getAskInfo";
	}
	
	/**
	 * 删除ask信息
	 * @return
	 */
	public String delAskInfo(){
		try {
			askService.delAskInfo(askNos);
			result=1;
		} catch (Exception e) {
			result=0;
			LogManager.getLogger().debug("删除问题信息失败",e);
		}
		return "delAskInfo";
	}
	/**
	 * 视频界面添加问答信息
	 * @return
	 */
	public String addAsks(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String askTime=sdf.format(new Date());
		Ask ask=new Ask();
		ask.setaTime(askTime);
		ask.setaContent(backAskBean.getaContent());
		ask.setaTitle(backAskBean.getaTitle());
		ask.setuNo((String) session.get("riuno"));
		CourseBean couu=(CourseBean) session.get("dancourse");
		ask.setCtNo(couu.getCtNo());
		System.out.println("添加的"+ask);
		 result=askService.addAsk(ask);
		 System.out.println("结果是"+result);
		return "shipin";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
}
