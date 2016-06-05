package com.dream.muke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.muke.entity.UCourseBean;
import com.dream.muke.mapper.UCourseMapper;
import com.dream.muke.service.UcourseService;
@Service("ucourseService")
public class UcourseServiceImpl implements UcourseService {
	@Autowired
	private UCourseMapper uCourseMapper;
	/**
	 * 查询UCourse信息返回到UCourseBean
	 * @param uCourseBean
	 * @return
	 */
	@Override
	public List<UCourseBean> findUcourse(UCourseBean uCourseBean) {
		return uCourseMapper.findUcourse(uCourseBean);
	}
	/**
	 * 总记录数
	 * @param uCourseBean
	 * @return
	 */
	@Override
	public int totalUcourse(UCourseBean uCourseBean) {
		return uCourseMapper.totalUcourse(uCourseBean);
	}
	/**
	 * 保存修改的信息
	 * @return
	 */
	@Override
	public int updateUcourseInfo(UCourseBean uCourseBean) {
		return uCourseMapper.updateUcourseInfo(uCourseBean);
	}

}
