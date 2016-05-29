package com.dream.muke.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.CommentBean;
import com.dream.muke.service.CommentService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("commentAction")
public class CommentAction implements ModelDriven<CommentBean>{
	private CommentBean commentBean;
	@Autowired
	private CommentService commentService;
	
	private Map<String,Object> comments=new HashMap<String, Object>(); //往后台传的json数据
	private String coNos; //接收评论编号，用逗号分割
	private int result; //返回操作结果

	public CommentBean getModel() {
		commentBean=new CommentBean();
		return commentBean;
	}
	
	public Map<String, Object> getComments() {
		return comments;
	}
	public int getResult() {
		return result;
	}

	public void setCoNos(String coNos) {
		this.coNos = coNos;
	}

	/**
	 * 获取所有的评论信息
	 * @return
	 */
	public String getAllComment(){
		comments.put("rows", commentService.getAllComment(commentBean));
		comments.put("total", commentService.getCommentTotal(commentBean));
		return "getAllComment";
	}
	
	/**
	 * 根据章节找到评论信息
	 * @return
	 */
	public String findCommentsByInfo(){
		System.out.println(commentBean.getChNo());
		if("0".equals( commentBean.getChNo() )){
			commentBean.setChNo(null);
			comments.put("rows", commentService.getAllComment(commentBean));
		}else{
			comments.put("rows", commentService.findCommentsByInfo(commentBean));
		}
		comments.put("total", commentService.getCommentTotal(commentBean));
		return "getAllComment";
	}
	
	/**
	 * 删除评论信息
	 * @return
	 */
	public String delComments(){
		result=commentService.delComments(coNos);
		return "delComments";
	}
}
