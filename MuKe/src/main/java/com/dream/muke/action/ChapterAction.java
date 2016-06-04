package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Chapter;
import com.dream.muke.entity.ChapterBean;
import com.dream.muke.service.ChapterService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("chapterAction")
public class ChapterAction implements SessionAware,ModelDriven<ChapterBean>{
	private ChapterBean chapterBean;
	@Autowired
	private ChapterService chapterService;
	List<ChapterBean> chapters;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	private int chStatu;
	Map<String,Object> map;
	public int getChStatu() {
		return chStatu;
	}

	public void setChStatu(int chStatu) {
		this.chStatu = chStatu;
	}
	
	
	public List<ChapterBean> getChapters() {
		return chapters;
	}

	public void setChapters(List<ChapterBean> chapters) {
		this.chapters = chapters;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	private Map<String, Object> session;
	
	//查找所有的章节信息
	public String findAllChapter(){
		chapters = chapterService.findAllChapter(Integer.parseInt(page),Integer.parseInt(rows));
		//System.out.println(chapters+"所有的章节");
		return "findAllChapter";
	}
	
	
	//根据课程编号或章节名字查找章节信息
	public String findChapterBycNoOrchName(){
		map = new HashMap<String, Object>();
		map.put("chName", chapterBean.getChName());
		map.put("cName", Integer.parseInt(chapterBean.getcName()));
		//System.out.println(chapterBean.getChName()+"   "+chapterBean.getcName()+"传过来的值");
		chapters = chapterService.findChapterBycNoOrchName(map);
		System.out.println(chapters+"根据课程编号或章节名字查找章节信息");
		return "findChapterBycNoOrchName";
	}
	
	
	//查看某一章节具体信息
	public String showChapterDetail(){
		map = new HashMap<String, Object>();
		map.put("chNo",chapterBean.getChNo());
		chapters = chapterService.showChapterDetail(map);
		System.out.println(chapters+"某一章节具体信息");
		return "showChapterDetail";
	}

	//更改选中章节的状态
	public String updateChapterStatus(){
		map = new HashMap<String, Object>();
		map.put("chNo", chapterBean.getChNo());
		map.put("chStatus", chapterBean.getChStatus());
		System.out.println(chapterBean.getChNo()+" "+chapterBean.getChStatus());
		chStatu = chapterService.updateChapterStatus(map);
		System.out.println(chStatu+"章节的状态");
		return "updateChapterStatus";
	}
	
	//删除选中章节
	public String delChapterInfo(){
		map = new HashMap<String, Object>();
		map.put("chNo", chapterBean.getChNo());
		map.put("chStatus", chapterBean.getChStatus());
		System.out.println(chapterBean.getChNo()+" "+chapterBean.getChStatus());
		chStatu = chapterService.delChapterInfo(map);
		System.out.println(chStatu+"章节的状态");
		return "delChapterInfo";
	}
	@Override
	public ChapterBean getModel() {
		chapterBean = new ChapterBean();
		return chapterBean;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
