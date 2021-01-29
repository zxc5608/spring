package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.config.ComponentScanJavaConfig;
import kr.or.ddit.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;

@ContextConfiguration(classes = ComponentScanJavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class componenScanJavaTest {
	
	
	@Resource(name = "userDao")
	private UserDao userDao;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	//@Repository어노테이션을 적용한userDaoIMpl스프링 빈이 정상적으로컨테이너에등록되어있는지 확인
	@Test
	public void userDaoImplSpringBeanTest() {
		assertNotNull(userDao);
		
		UserVo userVo = userDao.getUser("brown");
		assertEquals("브라운", userVo.getUsernm());
	}
	
	//userServiceImpl스프링 빈이 정상적으로 컨테이너에 등록되었는지 확인
	@Test
	public void userServiceImplSpringBeanTest() {
		assertNotNull(userService);
		
		UserVo userVo = userService.getUser("brown");
		assertEquals("브라운", userVo.getUsernm());
	}	

}
