package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Deeply;
import com.dream.muke.service.DeeplyService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("deeplyAction")
public class DeeplyAction implements ModelDriven<Deeply>{
	private Deeply deeply;
	@Autowired
	private DeeplyService deeplyService;
	private List<Deeply> deeplys;
	private Map<String,Object> map;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Deeply> getDeeplys() {
		return deeplys;
	}
	public void setDeeplys(List<Deeply> deeplys) {
		this.deeplys = deeplys;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	
	
	//查询课程难易度的所有信息
	public String findAllDeeplyInfo(){
		deeplys = deeplyService.findAllDeeplyInfo(Integer.parseInt(page),Integer.parseInt(rows));
		
		return "findAllDeeplyInfo";
	}
	
	
	//增加课程难易度信息
	public String addDeeplyInfo(){
		map= new HashMap<String, Object>();
		String dName=deeply.getdName();
		int dStatas=deeply.getdStatus();
		System.out.println("进来了...");
		System.out.println(dName+"   "+dStatas);
		map.put("dName",dName);
		map.put("dStatus", dStatas);
		
		status= deeplyService.addDeeplyInfo(map);
		System.out.println(status+"添加是否成功");
		return "addDeeplyInfo";
	}
	
	//修改课程难易程度信息
	public String updateDeeplyInfo(){
		map=new HashMap<String, Object>();
		map.put("dNo", deeply.getdNo());
		map.put("dName",deeply.getdName());
		map.put("dStatus", deeply.getdStatus());
		status= deeplyService.updateDeeplyInfo(map);
		System.out.println(status+"修改是否成功");

		return "updateDeeplyInfo";
	}
	
	//删除课程难易程度信息
	public String delDeeplyInfo(){
		map=new HashMap<String, Object>();
		String dNo=deeply.getdNo();
		int dStatus=deeply.getdStatus();
		map.put("dNo", dNo);
		//map.put("dStatus", dStatus);
		status= deeplyService.delDeeplyInfo(map);
		System.out.println(status+"结果........");
		return "delDeeplyInfo";
	}
	
	@Override
	public Deeply getModel() {
		deeply = new Deeply();
		return deeply;
	}
}
