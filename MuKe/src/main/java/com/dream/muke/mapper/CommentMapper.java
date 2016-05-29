package com.dream.muke.mapper;

import java.util.List;

import com.dream.muke.entity.CommentBean;

/**
 * 评论表映射接口
 * @author dream
 *
 */
public interface CommentMapper {
	/**
	 * 获取所有的评论信息
	 * @param commentBean
	 * @return
	 */
	public List<CommentBean> getAllComment(CommentBean commentBean);

	/**
	 * 获取当前评论的总数
	 * @param commentBean
	 * @return
	 */
	public int getCommentTotal(CommentBean commentBean);

	/**
	 * 根据章节找到评论信息
	 * @param commentBean
	 * @return
	 */
	public List<CommentBean> findCommentsByInfo(CommentBean commentBean);

	/**
	 * 删除评论信息
	 * @param coNos
	 * @return
	 */
	public int delComments(String[] coNos);
}