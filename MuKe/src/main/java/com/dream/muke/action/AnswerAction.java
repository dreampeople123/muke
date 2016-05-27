package com.dream.muke.action;

import org.springframework.stereotype.Controller;

import com.dream.muke.entity.Answer;
import com.dream.muke.service.AnswerService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("answerAction")
public class AnswerAction implements ModelDriven<Answer>{
	private Answer answer;
	private Answer jsonAnswer; //传到后台的json
	
	private AnswerService answerService;

	public Answer getModel() {
		answer=new Answer();
		return answer;
	}
	
	public Answer getJsonAnswer() {
		return jsonAnswer;
	}

	/**
	 * 获取这个问答的回答信息
	 * @return
	 */
	public String getAskAnswer(){
		System.out.println(answer);
		answerService.getAskAnswerByNo(answer.getaNo());
		return "getAskAnswer";
	}

}
