package com.dream.muke.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.service.AskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AskServiceImplTest {
	@Autowired
	private AskService askService;

	@Test
	public void testGetAskInfo() {
		System.out.println(askService.getAskInfo());
	}

}
