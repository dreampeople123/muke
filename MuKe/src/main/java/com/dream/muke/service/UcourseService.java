package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.UCourseBean;

public interface UcourseService {
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
