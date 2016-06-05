package com.dream.muke.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.Deeply;

/**
 * 课程难易度表映射接口
 * @author dream
 *
 */
@Repository("deeplyMapper")
public interface DeeplyMapper {
	/**
	 * 获取所有的难易度信息
	 * @return
	 */
	public List<Deeply> getDeeply();
}