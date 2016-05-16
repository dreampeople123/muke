package com.dream.muke.entity;

/**
 * 用户
 * @author dream
 *
 */
public class Users {
    private String uNo; //用户编号
    private String uName; //用户名
    private String uPwd; //用户密码
    private String uAddressProv; //省
    private String uAddressCity; //市
    private String uAddressCounty; //县
    private String uSex; //性别
    private String uUsign; //个性签名
    private String uPic; //头像
    private String uTel; //手机
    private int uIsTeacher; //表示不是教师 1表示为是教师
    private int uStudytime; //学习时间
    private int ustatus;//删除标记  0已被删除 1为存在
    
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuAddressProv() {
		return uAddressProv;
	}
	public void setuAddressProv(String uAddressProv) {
		this.uAddressProv = uAddressProv;
	}
	public String getuAddressCity() {
		return uAddressCity;
	}
	public void setuAddressCity(String uAddressCity) {
		this.uAddressCity = uAddressCity;
	}
	public String getuAddressCounty() {
		return uAddressCounty;
	}
	public void setuAddressCounty(String uAddressCounty) {
		this.uAddressCounty = uAddressCounty;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuUsign() {
		return uUsign;
	}
	public void setuUsign(String uUsign) {
		this.uUsign = uUsign;
	}
	public String getuPic() {
		return uPic;
	}
	public void setuPic(String uPic) {
		this.uPic = uPic;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}
	public int getuIsTeacher() {
		return uIsTeacher;
	}
	public void setuIsTeacher(int uIsTeacher) {
		this.uIsTeacher = uIsTeacher;
	}
	public int getuStudytime() {
		return uStudytime;
	}
	public void setuStudytime(int uStudytime) {
		this.uStudytime = uStudytime;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	
	public String toString() {
		return "Users [uNo=" + uNo + ", uName=" + uName + ", uPwd=" + uPwd
				+ ", uAddressProv=" + uAddressProv + ", uAddressCity="
				+ uAddressCity + ", uAddressCounty=" + uAddressCounty
				+ ", uSex=" + uSex + ", uUsign=" + uUsign + ", uPic=" + uPic
				+ ", uTel=" + uTel + ", uIsTeacher=" + uIsTeacher
				+ ", uStudytime=" + uStudytime + ", ustatus=" + ustatus + "]";
	}
}