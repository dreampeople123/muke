package com.dream.muke.service;

import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;

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
}
