package com.dream.muke.service;

import com.dream.muke.entity.CommunityHotCourseBean;
import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;

import java.util.List;
import java.util.Map;

import com.dream.muke.entity.Course;
import com.dream.muke.entity.CourseBean;

/**
 * 课程
 * @author Administrator
 *
 */
public interface CourseService {
	/**
	 * 上传新的课程
	 * @param course
	 * @param video
	 * @return
	 */
	public int uploadCourse(NewCourseUploadBean course, String videoPath,String chName,String uno);

	/**
	 * 上传新的章节
	 * @param cno
	 * @param videoPath
	 * @param chName
	 * @param uno
	 * @return
	 */
	public int uploadChapter(UploadChapterBean chapter);
	
	/**
	 * 获取热门课程
	 */
	public List<CommunityHotCourseBean> findCommunityHotCourse();

	List<Course> findCourseNameAndId();

	//查找所有课程信息
	List<CourseBean> findCourseInfo(Map<String, Object> map);
	
	//按照课程名或课程类别编号查找课程信息
	List<CourseBean> findCourseByInfo(Map<String, Object> map);
	
	//修改课程信息
	int updateCourseInfo(Map<String, Object> map);
}
