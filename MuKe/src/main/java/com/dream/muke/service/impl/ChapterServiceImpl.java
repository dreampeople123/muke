package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.ChapterBean;
import com.dream.muke.mapper.ChapterMapper;
import com.dream.muke.service.ChapterService;

@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	private ChapterMapper chapterMapper;

	public List<ChapterBean> getAllChapter() {
		return chapterMapper.getAllChapter();
	}

}
