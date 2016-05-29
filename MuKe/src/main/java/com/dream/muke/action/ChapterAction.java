package com.dream.muke.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.ChapterBean;
import com.dream.muke.service.ChapterService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("chapterAction")
public class ChapterAction implements ModelDriven<ChapterBean>{
	private ChapterBean chapterBean;
	private Map<String, Object> chapters=new HashMap<String, Object>(); //json数据
	@Autowired
	private ChapterService chapterService;

	public ChapterBean getModel() {
		chapterBean=new ChapterBean();
		return chapterBean;
	}
	
	public Map<String, Object> getChapters() {
		return chapters;
	}

	/**
	 * 获取所有的章节
	 * @return
	 */
	public String getAllChapter(){
		chapters.put("chapters", chapterService.getAllChapter());
		return "getAllChapter";
	}
}
