package com.dream.muke.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dream.muke.entity.NewCourseUploadBean;
import com.dream.muke.entity.UploadChapterBean;
import com.dream.muke.mapper.ChapterMapper;
import com.dream.muke.mapper.CourseMapper;
import com.dream.muke.mapper.UsersMapper;
import com.dream.muke.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ChapterMapper chapterMapper;
	@Autowired
	private UsersMapper usersMapper;
	
	@Transactional
	public int uploadCourse(NewCourseUploadBean course, String videoPath,String chName,String uno) {
		int r1,r2,r3;
		r1=addNewCourse(course);
		
		UploadChapterBean chapter=new UploadChapterBean(chName,course.getCno(),videoPath,0,uno);
		r2=addNewChapter(chapter);
		r3=addTeacherCourse(chapter);
		
		if(r1>0 && r2>0 && r3>0){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 添加新课程
	 * @param course
	 * @return
	 */
	@Transactional
	public int addNewCourse(NewCourseUploadBean course){
		return courseMapper.addNewCourse(course);
	}
	
	/**
	 * 添加新章节
	 * @param params
	 * @return
	 */
	@Transactional
	public int addNewChapter(UploadChapterBean chapter){
		return chapterMapper.addNewChapter(chapter);
	}
	
	/**
	 * 添加教师维护课程的信息
	 * @param chapter
	 * @return
	 */
	@Transactional
	public int addTeacherCourse(UploadChapterBean chapter){
		return usersMapper.addTeacherCourse(chapter);
	}

	public int uploadChapter(UploadChapterBean chapter) {
		return chapterMapper.addNewChapter(chapter);
	}
}
