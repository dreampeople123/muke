package com.dream.muke.entity;

public class BackAskBean {
    private String aNo;
    private CType cType;
    private Users user;
    private String aTitle;
    private String aTime;
    private int aStatus;
    private String aContent;
    
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public CType getcType() {
		return cType;
	}
	public void setcType(CType cType) {
		this.cType = cType;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public int getaStatus() {
		return aStatus;
	}
	public void setaStatus(int aStatus) {
		this.aStatus = aStatus;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	
	public String toString() {
		return "BackAskBean [aNo=" + aNo + ", cType=" + cType + ", user="
				+ user + ", aTitle=" + aTitle + ", aTime=" + aTime
				+ ", aStatus=" + aStatus + ", aContent=" + aContent + "]";
	}
}
