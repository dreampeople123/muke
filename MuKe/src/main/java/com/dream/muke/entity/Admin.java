package com.dream.muke.entity;

/**
 * 管理员
 * @author Administrator
 *
 */
public class Admin {
    private String aId; //管理员编号
    private String aName; //管理员名字
    private String aPwd; //管理员密码
    private int aStatus; //删除标记  0已被删除 1为存在
    
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	public int getaStatus() {
		return aStatus;
	}
	public void setaStatus(int aStatus) {
		this.aStatus = aStatus;
	}
	
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aPwd=" + aPwd
				+ ", aStatus=" + aStatus + "]";
	}
}
