package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;

@ContextConfiguration(locations = {"classpath:/kr/or/ddit/ioc/component-scan.xml",
					"classpath:/kr/or/ddit/config/spring/datasource-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class componenScanTest {
	
	
	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Resource(name="userService")
	private UserService userService;
	
	//@Repository������̼��� ������userDaoIMpl������ ���� ���������������̳ʿ���ϵǾ��ִ��� Ȯ��
	@Test
	public void userDaoImplSpringBeanTest() {
		assertNotNull(userDao);
		
		UserVo userVo = userDao.selectUser("brown");
		assertEquals("브라운", userVo.getUsernm());
	}
	
	//userServiceImpl������ ���� ���������� �����̳ʿ� ��ϵǾ����� Ȯ��
	@Test
	public void userServiceImplSpringBeanTest() {
		assertNotNull(userService);
		
		UserVo userVo = userService.selectUser("brown");
		assertEquals("브라운", userVo.getUsernm());
	}	

}
