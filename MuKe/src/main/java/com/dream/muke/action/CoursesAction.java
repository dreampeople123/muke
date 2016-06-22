package com.dream.muke.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dream.muke.entity.ChapterBean;
import com.dream.muke.entity.CommentBean;
import com.dream.muke.entity.CourseBean;
import com.dream.muke.entity.UCourseBean;
import com.dream.muke.entity.UsersBean;
import com.dream.muke.entity.frontAsk;
import com.dream.muke.service.AskService;
import com.dream.muke.service.ChapterService;
import com.dream.muke.service.CommentService;
import com.dream.muke.service.CourseService;
import com.dream.muke.service.UcourseService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("coursesAction")
public class CoursesAction implements ModelDriven<CourseBean>,SessionAware{
	private CourseBean courseBean;
	private List<CourseBean> coursesInfo;
	@Autowired
	private CourseService courseService;
	@Autowired
	private UcourseService ucourseService;
	@Autowired
	private ChapterService chapterService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private AskService askService;
	private String page;//进行分页的page
	private String rows;//进行分页的rows
	private Map<String,Object> map;
	//增修返回值
	private int status;
	//在点击查看视频界面中穿过来的值
		private String uno;//用户编号
		private String chapterno;//章节编号
		private String cno;//课程编号
		private Map<String, Object> session;
		@Override
		public void setSession(Map<String, Object> session) {//获得session
			this.session=session;
		}
		public void setUno(String uno) {
			this.uno = uno;
		}
		public void setChapterno(String chapterno) {
			this.chapterno = chapterno;
		}
		public void setCno(String cno) {
			this.cno = cno;
		}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public List<CourseBean> getCoursesInfo() {
		return coursesInfo;
	}
	public void setCoursesInfo(List<CourseBean> coursesInfo) {
		this.coursesInfo = coursesInfo;
	}
	
	//查找所有课程信息
	public String findCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		coursesInfo = courseService.findCourseInfo(map);
		return "findCourseInfo";
	}
	
	//按照课程名或课程类别编号查找课程信息
	public String findCourseByInfo(){
		map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("rows", rows);
		map.put("cName", courseBean.getcName());
		map.put("ctNo", Integer.parseInt(courseBean.getCtNo()));
		
		System.out.println(courseBean.getcName()+"传过来的类别名");
		System.out.println(Integer.parseInt(courseBean.getCtNo())+"闯过来的类别id");
		coursesInfo = courseService.findCourseByInfo(map);
		return "findCourseByInfo";
	}
	
	//修改课程信息
	public String updateCourseInfo(){
		map = new HashMap<String, Object>();
		map.put("cNo", courseBean.getcNo());
		map.put("cName", courseBean.getcName());
		map.put("cUpstatus", courseBean.getcUpstatus());
		map.put("cStatus", courseBean.getcStatus());
		
		status = courseService.updateCourseInfo(map);
		return "updateCourseInfo";
	}
	/**
	 * 获得视频界面的所有信息
	 * @return
	 */
	public String getshipinDataInfo(){
		session.put("riuno", uno);
		session.put("richapterno", chapterno);
		session.put("ricno", cno);
		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, chapterno);
		//调用函数查找评论信息
		getCommentBean(chapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 获取查看视频时的评论信息
	 * @param chapterno
	 */
	public void getCommentBean(String chapterno){
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo(chapterno);
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentsByInfo(com); //获得评论信息
		session.put("comments", comments);
	}
	/**
	 * 获得查看视频界面的章节同学信息
	 */
	public void getChapterTong(String cno,String uno,String chapterno){
		UCourseBean ucur=new UCourseBean();
		ucur.setcNo(cno);
		ucur.setuNo(uno);
		ucur.setPage("1");
		ucur.setRows("10");
		UCourseBean daucourse=ucourseService.findUcourse(ucur).get(0);
		session.put("daucourse", daucourse);//uno 和cno对应的用户课程
		ChapterBean danchapter=new ChapterBean();
		map = new HashMap<String, Object>();
		//数据放入map中方便mapper
		map.put("cNo",cno);
		map.put("uNo",uno);
		map.put("chNo",chapterno);
		List<ChapterBean> chapters=chapterService.findChapterBycNoOrchName(map);//获得章节信息
		session.put("chapters", chapters);
		CourseBean dancourse= courseService.findBycno(cno).get(0);//获得课程名称
		session.put("dancourse", dancourse);
		for(int i=0;i<chapters.size();i++){
			if(Integer.parseInt(chapters.get(i).getChNo())==Integer.parseInt(chapterno)){
				danchapter=chapters.get(i);
			}
		}
		session.put("danchapter", danchapter);//当前的章节
		List<UsersBean> tongxue=ucourseService.findUsBychano(map);//查询这门课程有什么人在学 
		int counu=ucourseService.totalChapterno(map);//查询这门课程有多少人在学 
		List<CourseBean> sameUcourse=ucourseService.sameByCno(cno);//查询学习这门课程的同学学习的其他课程
		session.put("counu",counu);
		session.put("tongxue",tongxue);
		session.put("sameUcourse", sameUcourse);
	}
	/**
	 * 获得问答的信息
	 * @param cno
	 */
	public void getaskin(String cno){
		CourseBean coure=(CourseBean) courseService.findBycno(cno).get(0);
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", cno);
		maps.put("ctNo", coure.getCtNo());
		//根据cno查询问题
		List<frontAsk> asks=askService.findForntAsk(maps);
		session.put("asks", asks);
		System.out.println("查到的asks"+asks);
	}
	/**
	 * 获得视频界面所有的问答信息
	 */
	public String getAllAskInfo(){
		String cno=(String) session.get("ricno");
		System.out.println("quanbu"+cno);
		//查询问答信息
		getaskin( cno);
		status = 1;
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 点击某一章节后
	 */
	public String getshipinBychapter() {
		String uno=(String) session.get("riuno");
		String cno=(String) session.get("ricno");
		session.put("richapterno", chapterno);
		session.put("ricno", cno);
		session.put("riuno", uno);
		//调用函数查找章节信息，同学信息有关课程
		getChapterTong( cno, uno, chapterno);
		//调用函数查找评论信息
		getCommentBean(chapterno);
		//问答信息
		getaskin(cno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 点击精华问答信息
	 * @return
	 */
	public String getJinhuaAskInfo(){
		String cno=(String) session.get("ricno");
		System.out.println("jingha"+cno);
		CourseBean coure=(CourseBean) courseService.findBycno(cno).get(0);
		Map<String, Object>  maps=new HashMap<String, Object>();
		maps.put("cNo", cno);
		maps.put("ctNo", coure.getCtNo());
		//根据cno查询问题
		List<frontAsk> asks=askService.findJinAskByCtype(maps);
		session.put("asks", asks);
		System.out.println("查到的asks"+asks);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 视频界面点击最新的评论
	 * @return
	 */
	public String getLastComInfo(){
		String chapterno=(String) session.get("richapterno");
		System.out.println("zuixin"+chapterno);
		getCommentBean(chapterno);
		status = 1;//表示信息查到成功
		return "shipinInfo";//借用上面参数返回1
	}
	/**
	 * 视频界面点击点赞查询评论
	 * @return
	 */
	public String getComInfoBydian(){
		String chapterno=(String) session.get("richapterno");
		System.out.println("点赞"+chapterno);
		CommentBean com=new CommentBean();//临时的来查询的CommentBean
		com.setChNo(chapterno);
		com.setPage(1);
		com.setRows(10);
		List<CommentBean> comments=commentService.findCommentByDian(com); //获得评论信息
		session.put("comments", comments);
		return chapterno;
		
	}
	@Override
	public CourseBean getModel() {
		courseBean = new CourseBean();
		return courseBean;
	}
}
