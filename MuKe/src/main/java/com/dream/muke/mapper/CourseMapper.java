package com.dream.muke.mapper;

import com.dream.muke.entity.NewCourseUploadBean;

/**
 * 课程表映射接口
 * @author dream
 *
 */
public interface CourseMapper {
	/**
	 * 添加新课程
	 * @param course
	 * @return
	 */
	public int addNewCourse(NewCourseUploadBean course);
}