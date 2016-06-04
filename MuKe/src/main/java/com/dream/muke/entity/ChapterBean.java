package com.dream.muke.entity;

/**
 * 章节
 * @author dream
 *
 */
public class ChapterBean {
    private int chNo;
    private String chName;
    private String cName;
    private String chContent;
    private int chOrder;
    private int chStatus;
    
	
	public int getChNo() {
		return chNo;
	}
	public void setChNo(int chNo) {
		this.chNo = chNo;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
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
	@Override
	public String toString() {
		return "ChapterBean [chNo=" + chNo + ", chName=" + chName + ", cName="
				+ cName + ", chContent=" + chContent + ", chOrder=" + chOrder
				+ ", chStatus=" + chStatus + "]";
	}
	public ChapterBean(int chNo, String chName, String cName,
			String chContent, int chOrder, int chStatus) {
		super();
		this.chNo = chNo;
		this.chName = chName;
		this.cName = cName;
		this.chContent = chContent;
		this.chOrder = chOrder;
		this.chStatus = chStatus;
	}
	public ChapterBean() {
		super();
	}

	
}