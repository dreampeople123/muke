package com.dream.muke.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.ChapterBean;
import com.dream.muke.entity.UploadChapterBean;

/**
 * 章节表映射接口
 * @author dream
 *
 */
@Repository("chapterMapper")
public interface ChapterMapper {
	/**
	 * 获取所有的章节信息
	 * @return
	 */
	public List<ChapterBean> getAllChapter();

	/**
	 * 添加章节
	 * @param params
	 * @return
	 */
	public int addNewChapter(UploadChapterBean chapter);
}