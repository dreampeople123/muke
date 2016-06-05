package com.dream.muke.mapper;

import java.util.List;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.UploadChapterBean;

/**
 * 用户映射接口
 * @author dream
 *
 */
public interface UsersMapper {
	/**
	 * 获取该教师维护的所有的课程
	 * @param uNo
	 * @return
	 */
	public List<Course> getTeacherCourse(String uNo);

	/**
	 * 添加教师维护课程信息
	 * @param chapter
	 * @return
	 */
	public int addTeacherCourse(UploadChapterBean chapter);

}