package com.dream.muke.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.ChapterBean;

/**
 * 章节表映射接口
 * @author dream
 *
 */
@Repository
public interface ChapterMapper {
	//查询所有的chapter内容
	List<ChapterBean> getAllChpater(Map<String, Integer> map);
	
	//根据章节编号,课程编号查找章节信息
	List<ChapterBean> getChapterByChnoOrCname(Map<String, Object> map);

	//根据章节编号查找章节信息
	List<ChapterBean> getChapterDetailByChno(Map<String, Object> map);

	//修改章节状态
	int updateChapterStatus(Map<String, Object> map);
	
	//删除章节信息
	int delChapterInfo(Map<String, Object> map);
}