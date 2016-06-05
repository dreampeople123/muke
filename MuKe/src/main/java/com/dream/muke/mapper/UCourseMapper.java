package com.dream.muke.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dream.muke.entity.UCourseBean;

/**
 * 用户选择课程表的映射接口
 * @author dream
 *
 */
@Repository("uCourseMapper")
public interface UCourseMapper {
	/**
	 * 查询UCourse信息返回到UCourseBean
	 * @param uCourseBean
	 * @return
	 */
	public List<UCourseBean> findUcourse(UCourseBean uCourseBean);
	/**
	 * 总记录数
	 * @param uCourseBean
	 * @return
	 */
	public int totalUcourse(UCourseBean uCourseBean);
	/**
	 * 保存修改的信息
	 * @return
	 */
	public int updateUcourseInfo(UCourseBean uCourseBean);
}