package com.dream.muke.entity;

/**
 * 章节bean，外键改为类
 * @author dream
 *
 */
public class ChapterBean {
    private String chNo;
    private String chName;
    private Course course;
    private String chContent;
    private int chOrder;
    private int chStatus;
    
	public String getChNo() {
		return chNo;
	}
	public void setChNo(String chNo) {
		this.chNo = chNo;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getChContent() {
		return chContent;
	}
	public void setChContent(String chContent) {
		this.chContent = chContent;
	}
	public int getChOrder() {
		return chOrder;
	}
	public void setChOrder(int chOrder) {
		this.chOrder = chOrder;
	}
	public int getChStatus() {
		return chStatus;
	}
	public void setChStatus(int chStatus) {
		this.chStatus = chStatus;
	}
	
	public String getInfo(){ //课程名-章节名
		return course.getcName()+"-"+chName;
	}
	
	public String toString() {
		return "ChapterBean [chNo=" + chNo + ", chName=" + chName + ", course="
				+ course + ", chContent=" + chContent + ", chOrder=" + chOrder
				+ ", chStatus=" + chStatus + "]";
	}
}