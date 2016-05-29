package com.dream.muke.service;

import java.util.List;

import com.dream.muke.entity.CommentBean;

public interface CommentService {
	/**
	 * 获取所有的评论信息
	 * @param commentBean
	 * @return
	 */
	public List<CommentBean> getAllComment(CommentBean commentBean);

	/**
	 * 获取当前评论的总数
	 * @param commentBean
	 */
	public int getCommentTotal(CommentBean commentBean);

	/**
	 * 根据章节找到评论信息
	 * @param commentBean
	 */
	public List<CommentBean> findCommentsByInfo(CommentBean commentBean);

	/**
	 * 删除评论信息
	 * @param coNos
	 */
	public int delComments(String coNos);

}
