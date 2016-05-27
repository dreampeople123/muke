package com.dream.muke.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.Admin;
import com.dream.muke.service.AdminService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminServiceImplTest {
	@Autowired
	private AdminService adminService;
	@Test
	public void testAddAdmin() {
		Admin ads=new Admin();
		ads.setaName("d");
		ads.setaPwd("d");
		int res=adminService.addAdmin(ads);
		System.out.println("结果是"+res);
	}
	@Test
	public void testUpdateAdmin() {
		Admin ads=new Admin();
		ads.setaId("1004");
		ads.setaName("e");
		ads.setaPwd("b");
		int res=adminService.updateAdmin(ads);
		System.out.println("结果是"+res);
	}
	@Test
	public void testDelAdmin() {
		int res=adminService.delAdmin("1004");
		System.out.println("结果是"+res);
	}

}
