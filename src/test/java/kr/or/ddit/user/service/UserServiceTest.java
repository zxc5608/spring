package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.model.UserVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/ioc/ioc.xml")
public class UserServiceTest {

	@Resource(name="userService")
	private UserService userService;
	@Test
	public void UserServiceTest() {
		/***Given***/
		String userid= "brown";

		/***When***/
		UserVo uservo= userService.getUser(userid);

		/***Then***/
		assertEquals("ºê¶ó¿î", uservo.getUsernm());
	}

}
