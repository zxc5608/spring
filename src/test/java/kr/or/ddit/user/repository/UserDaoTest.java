package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.model.UserVo;

//������ ȯ�濡�� junit �ڵ带 ���� => junit�ڵ嵵 ������ ������ ���
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/kr/or/ddit/ioc/ioc.xml")
public class UserDaoTest {
//		���� �ް���� ������ �� 
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void getUserTest() {
		/***Given***/
		String userid= "brown";

		/***When***/
		UserVo userVo= userDao.getUser(userid);
		
		/***Then***/
		assertEquals("����", userVo.getUsernm());
		
	}

}
